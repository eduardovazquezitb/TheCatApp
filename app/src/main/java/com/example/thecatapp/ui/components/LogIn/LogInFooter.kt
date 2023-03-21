package com.example.thecatapp.ui.components.LogIn

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.R

@Composable
fun LogInFooter(
    onSignInClick : (() -> Unit)? = null,
    onNoAccountClick: (() -> Unit)? = null
) {
    Button(
        onClick = { if(onSignInClick != null) onSignInClick() },
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .fillMaxWidth()
    ) {
        Text(
            fontSize = 18.sp,
            text = stringResource(id = R.string.sign_in_title)
        )
    }
    TextButton(onClick = { if(onNoAccountClick != null) onNoAccountClick() }) {
        Text(text= stringResource(id = R.string.no_account))
    }
    Spacer(modifier = Modifier.padding(12.dp))
}