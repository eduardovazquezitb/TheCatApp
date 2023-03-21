package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.ListViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun ListDisplayer(
    viewModel : ListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()
    /*val navigator = ListNavigator()
    val context = LocalContext.current as Activity*/

    AppScaffold(
        activityName = stringResource(id = R.string.cat_list),
        isLoading = uiState.value.isLoading,
        isError = uiState.value.isError
    ) {
        CardList(catList = uiState.value.catList)
    }
}