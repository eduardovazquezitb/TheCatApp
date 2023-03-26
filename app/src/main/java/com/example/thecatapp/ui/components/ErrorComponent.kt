package com.example.affirmations.ui.components

import android.os.Build
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.thecatapp.R
import com.example.thecatapp.ui.viewmodel.DistractionViewModel
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ErrorComponent(
    modifier: Modifier=Modifier,
    onTryAgainClick : (() -> Unit)? = null,
    viewModel: DistractionViewModel = viewModel(key = "error")
)
{
    val uiState = viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    LaunchedEffect(true){
        viewModel.loadRandomAnimation()
    }

    Text(
        text = stringResource(id = R.string.error),
        fontSize = 20.sp,
        modifier = modifier.padding(top=12.dp)
    )
    if(uiState.value != null){
        Spacer(modifier = modifier.padding(12.dp))
        CoilImage(
            imageModel = { uiState.value!! }, // URL of an animated image.
            imageLoader = { imageLoader },
            modifier = modifier
                .padding(12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        )
    }
    if(onTryAgainClick != null){
        TextButton(onClick = { onTryAgainClick() }) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}

@Preview
@Composable
private fun LoadingComponentPreview() {
    ErrorComponent()
}