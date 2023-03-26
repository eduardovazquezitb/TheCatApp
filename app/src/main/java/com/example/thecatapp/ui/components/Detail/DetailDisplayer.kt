package com.example.thecatapp.ui.components.Detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.DetailUiState
import com.example.thecatapp.ui.viewmodel.DetailViewModel

@Composable
fun DetailDisplayer(
    viewModel: DetailViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    var breed : BreedDto? = null
    var catInfo : CatInfoDto? = null
    var catName : String = stringResource(id = R.string.detail_title)
    if(uiState.value is DetailUiState.Success){
        val state = uiState.value as DetailUiState.Success
        breed = state.breed
        catInfo = state.catInfo
        catName = breed.name
    }

    AppScaffold(
        activityName = catName,
        isLoading = uiState.value is DetailUiState.IsLoading,
        isError = uiState.value is DetailUiState.IsError
    ) { modifier ->
        if(breed != null){
            DetailContainer(modifier = modifier) {
                CatDetailDisplayer(
                    breed,
                    catInfo,
                    modifier
                )
            }
        }

    }
}