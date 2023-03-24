package com.example.thecatapp.ui.components.Detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.DetailUiState
import com.example.thecatapp.ui.viewmodel.DetailViewModel

@Composable
fun DetailDisplayer(
    viewModel: DetailViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    val breed : BreedDto? =
        if(uiState.value is DetailUiState.Success)
            (uiState.value as DetailUiState.Success).breed
        else
            null

    val catName : String =
        if(breed == null)
            stringResource(id = R.string.detail_title)
        else
            breed.name

    AppScaffold(
        activityName = catName,
        isLoading = uiState.value is DetailUiState.IsLoading,
        isError = uiState.value is DetailUiState.IsError
    ) { modifier ->
        if(breed != null){
            DetailContainer(modifier = modifier) {
                CatDetailDisplayer(
                    breed,
                    modifier
                )
            }
        }

    }
}