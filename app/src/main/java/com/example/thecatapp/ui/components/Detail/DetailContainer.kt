package com.example.thecatapp.ui.components.Detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailContainer(
    modifier: Modifier = Modifier,
    children: @Composable () -> Unit,
){
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(24.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
    ){
        children()
    }
}