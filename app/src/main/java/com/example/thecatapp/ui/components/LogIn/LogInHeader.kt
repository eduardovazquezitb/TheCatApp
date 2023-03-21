package com.example.thecatapp.ui.components.LogIn

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogInHeader(
    title: String,
    subtitle: String
){
    Spacer(modifier = Modifier.padding(12.dp))
    Text(
        text = title,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = subtitle,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    )
}