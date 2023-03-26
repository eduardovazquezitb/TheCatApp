package com.example.thecatapp.ui.components.Register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.R

@Composable
fun RegisterFooter(
    errorMessage: String = "",
    onRegisterClick : (() -> Unit)? = null
) {
    Text(
        text = errorMessage,
        fontSize = 16.sp,
        color = MaterialTheme.colors.onError
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Button(
        onClick = { if(onRegisterClick != null) onRegisterClick() },
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .fillMaxWidth()
    ) {
        Text(
            fontSize = 18.sp,
            text = stringResource(id = R.string.register_title)
        )
    }
    Spacer(modifier = Modifier.padding(12.dp))
}