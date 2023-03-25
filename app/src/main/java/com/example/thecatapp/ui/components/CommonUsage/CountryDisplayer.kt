package com.example.thecatapp.ui.components.CommonUsage

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.viewmodel.CountryDisplayerUiState
import com.example.thecatapp.ui.viewmodel.CountryDisplayerViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CountryDisplayer(
    countryCode: String,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    viewModel: CountryDisplayerViewModel = viewModel(key = countryCode)
) {
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(countryCode){
        viewModel.loadCountry(countryCode)
    }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){

        if(uiState.value is CountryDisplayerUiState.IsLoading || uiState.value is  CountryDisplayerUiState.IsError){
            Spacer(modifier = modifier.padding(size))
            Spacer(modifier = modifier.padding(4.dp))
            Text(
                text = countryCode
            )
        }
        else{
            val country = (uiState.value as CountryDisplayerUiState.Success).country
                if(country.flags != null) {
                    GlideImage( // https://github.com/skydoves/landscapist
                        imageModel = {
                            country.flags.png ?: country.flags.svg
                        },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Fit,
                            contentDescription = country.flags.alt ?: countryCode
                        ),
                        modifier = modifier
                            .size(size)
                    )
                } else
                    Spacer(modifier = modifier.padding(size))
                Spacer(modifier = modifier.padding(4.dp))
                Text(
                    text =
                        if(country.name != null)
                            country.name.common ?: countryCode
                        else
                            countryCode
                )
        }
    }
}

@Preview
@Composable
fun PreviewCountryDisplayer(){
    CountryDisplayer("BE")
}