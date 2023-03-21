package com.example.thecatapp.ui.components.Detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thecatapp.model.CatInfo

@Composable
fun CatDetailDisplayer(
    catInfo: CatInfo,
    modifier: Modifier = Modifier
) {
    Text(
        text="I'm a kitty!" + catInfo.id,
        modifier = modifier
    )
}