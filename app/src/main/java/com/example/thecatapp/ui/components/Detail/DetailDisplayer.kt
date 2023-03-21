package com.example.thecatapp.ui.components.Detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.DetailViewModel

@Composable
fun DetailDisplayer(
    viewModel: DetailViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    val catName : String =
        if(uiState.value.catInfo != null && uiState.value.catInfo!!.breeds.isNotEmpty())
            uiState.value.catInfo!!.breeds[0].name
        else
            stringResource(id = R.string.detail_title)

    AppScaffold(
        activityName = catName,
        isLoading = uiState.value.isLoading,
        isError = uiState.value.isError
    ) { modifier ->
        if(uiState.value.catInfo != null)
            CatDetailDisplayer(
                catInfo = uiState.value.catInfo!!,
                modifier = modifier
            )
    }
}