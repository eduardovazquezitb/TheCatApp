package com.example.thecatapp.ui.components


import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.LogIn.LogInBody
import com.example.thecatapp.ui.components.LogIn.LogInFooter
import com.example.thecatapp.ui.components.LogIn.LogInHeader
import com.example.thecatapp.ui.navigation.MainNavigator
import com.example.thecatapp.ui.viewmodel.MainViewModel

@Composable
fun LogInDisplayer(
    viewModel : MainViewModel
) {
    val isError = viewModel.uiState.collectAsState()
    val navigator = MainNavigator()
    val context = LocalContext.current as Activity

    AppScaffold(
        activityName = stringResource(id = R.string.sign_in_title),
        isLoading = false,
        isError = false
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            LogInHeader(
                title = stringResource(id = R.string.login_header_title),
                subtitle = stringResource(id = R.string.login_header_subtitle)
            )
            LogInBody(
                isError = isError.value,
                username = viewModel.username.value,
                setUsername = {
                    viewModel.username.value = it
                },
                password = viewModel.password.value,
                setPassword = {
                    viewModel.password.value = it
                },
                modifier = Modifier.weight(1F)
            )
            LogInFooter(
                onSignInClick = {
                    if(viewModel.CheckUserCredentials())
                        navigator.goToListDisplay(context)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LogInDisplayer(MainViewModel())
}