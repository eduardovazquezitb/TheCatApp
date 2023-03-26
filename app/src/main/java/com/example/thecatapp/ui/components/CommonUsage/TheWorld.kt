package com.example.thecatapp.ui.components.CommonUsage

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.thecatapp.R

@Composable
fun TheWorld(
    modifier : Modifier = Modifier,
    size: Dp = 24.dp
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Default.Public,
            contentDescription = "Open Options",
            modifier = modifier.size(size)
        )
        Spacer(modifier = modifier.padding(4.dp))
        Text(
            text = stringResource(id = R.string.anywhere)
        )
    }
}