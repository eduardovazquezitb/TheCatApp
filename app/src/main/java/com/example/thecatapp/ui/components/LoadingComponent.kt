package com.example.affirmations.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.R
import com.example.thecatapp.ui.viewmodel.DistractionViewModel

@Composable
fun Loadingcomponent(
    modifier: Modifier=Modifier,
    viewModel: DistractionViewModel = viewModel(key = "loading")
)
{
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(true){
        viewModel.loadRandomImage()
    }

    Text(
        text = stringResource(id = R.string.loading),
        fontSize = 20.sp,
        modifier = modifier.padding(top=12.dp)
    )
    if(uiState.value != null){
        Spacer(modifier = modifier.padding(12.dp))
        Image(
            painter = painterResource(id = uiState.value!!),
            contentDescription = stringResource(id = R.string.distraction),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .padding(12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        )
    }
}

@Preview
@Composable
private fun LoadingComponentPreview() {
    Loadingcomponent()
}