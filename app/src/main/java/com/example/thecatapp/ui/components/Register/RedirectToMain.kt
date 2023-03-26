package com.example.thecatapp.ui.components.Register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thecatapp.R

@Composable
fun RedirectToMain(
    onRedirectClick : () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = stringResource(id = R.string.email_sent_title),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.email_sent_subtitle),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        TextButton(onClick = { onRedirectClick() }) {
            Text(text= stringResource(id = R.string.go_back_to_main))
        }
    }
}