package com.example.thecatapp.ui.components.LogIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Shield
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.thecatapp.R

@Composable
fun LogInBody(
    isError: Boolean,
    username: String,
    setUsername: (String) -> Unit,
    password: String,
    setPassword: (String) -> Unit,
    modifier : Modifier = Modifier,
    usernamePlaceholder: String = stringResource(id = R.string.username_placeholder),
    passwordPlaceholder: String = stringResource(id = R.string.password_placeholder),
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){

        InputBox(
            value = username,
            placeholder = usernamePlaceholder,
            onValueChange = {
                setUsername(it)
            },
            isError = isError,
            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = stringResource(id = R.string.email_icon_alt)
                )
            }
        )

        Spacer(modifier = Modifier.padding(4.dp))

        InputBox(
            value = password,
            placeholder = passwordPlaceholder,
            onValueChange = {
                setPassword(it)
            },
            isError = isError,
            leadingIcon = {
                Icon(
                    Icons.Default.Shield,
                    contentDescription = stringResource(id = R.string.password_icon_alt)
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )
    }
}