package com.example.thecatapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.LogIn.LogInBody
import com.example.thecatapp.ui.components.LogIn.LogInHeader
import com.example.thecatapp.ui.components.Register.RegisterFooter
import com.example.thecatapp.ui.viewmodel.RegisterUiState
import com.example.thecatapp.ui.viewmodel.RegisterViewModel

@Composable
fun RegisterDisplayer(
    viewModel : RegisterViewModel
) {
    val uiState = viewModel.uiState.collectAsState()
    val errorMessage =
        if(uiState.value is RegisterUiState.IsNotOk){
            val state = (uiState.value as RegisterUiState.IsNotOk)
            stringResource(id = state.message).replace("%", state.parameter)
        }
        else
            ""

    AppScaffold(
        activityName = stringResource(id = R.string.register_title),
        isLoading = false,
        isError = false
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            LogInHeader(
                title = stringResource(id = R.string.register_header_title),
                subtitle = stringResource(id = R.string.register_header_subtitle)
            )
            LogInBody(
                isError = uiState.value is RegisterUiState.IsNotOk,
                username = viewModel.username.value,
                setUsername = {
                    viewModel.SetUsername(it)
                },
                password = viewModel.password.value,
                setPassword = {
                    viewModel.SetPassword(it)
                },
                modifier = Modifier.weight(1F)
            )
            RegisterFooter(
                errorMessage,
                onRegisterClick = {
                    viewModel.CheckUserCredentials()
                }
            )
        }
    }
}