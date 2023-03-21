package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.ListViewModel

@Composable
fun ListDisplayer(
    viewModel : ListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    AppScaffold(
        activityName = stringResource(id = R.string.cat_list),
        isLoading = uiState.value.isLoading,
        isError = uiState.value.isError
    ) {
        CardList(catList = uiState.value.catList)
    }
}