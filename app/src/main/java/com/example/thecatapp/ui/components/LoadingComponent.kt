package com.example.affirmations.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.R

@Composable
fun Loadingcomponent(
    modifier: Modifier=Modifier
)
{
    Text(
        text = stringResource(id = R.string.loading),
        fontSize = 20.sp,
        modifier = modifier.padding(top=12.dp)
    )
}

@Preview
@Composable
private fun LoadingComponentPreview() {
    Loadingcomponent()
}