package com.example.thecatapp.ui.components.ListDisplayer

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto
import com.example.thecatapp.ui.navigation.ListNavigator
import com.example.thecatapp.ui.viewmodel.CatCardUiState
import com.example.thecatapp.ui.viewmodel.CatCardViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CatCard (
    breed: BreedDto,
    modifier: Modifier = Modifier,
    viewModel: CatCardViewModel = viewModel(key = breed.id)
) {
    val uiState = viewModel.uiState.collectAsState()
    LaunchedEffect(breed.id){
        viewModel.loadCatImage(breed.id)
    }
    val navigator = ListNavigator()
    val activity = LocalContext.current as Activity

    var catinfo : CatInfoDto? = null
    if(uiState.value is CatCardUiState.Success)
        catinfo = (uiState.value as CatCardUiState.Success).catInfo

    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(24.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        contentColor = MaterialTheme.colors.onSecondary,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .size(128.dp)
            .clickable { navigator.goToDetail(activity, breed, catinfo) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
        ){
            Spacer(modifier=modifier.padding(start=8.dp))
            if(uiState.value is CatCardUiState.IsLoading || uiState.value is CatCardUiState.IsError){
                Spacer(
                    modifier = modifier
                        .size(110.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            else{
                val catInfo = (uiState.value as CatCardUiState.Success).catInfo
                GlideImage( // https://github.com/skydoves/landscapist
                    imageModel = {
                        catInfo.url
                    },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop
                    ),
                    modifier = modifier
                        .size(110.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }

            Spacer(modifier = modifier.padding(start=8.dp))
            BreedDescription(
                breed,
                modifier
            )
        }
    }
}