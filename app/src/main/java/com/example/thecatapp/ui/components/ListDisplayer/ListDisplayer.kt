package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.example.thecatapp.R
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.viewmodel.ListUiState
import com.example.thecatapp.ui.viewmodel.ListViewModel

@Composable
fun ListDisplayer(
    viewModel : ListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    var catList : List<BreedDto> = listOf()
    var country : String? = null
    var isFilterExpanded = false

    if(uiState.value is ListUiState.Success){
        val value = uiState.value as ListUiState.Success
        catList = value.catList
        country = value.country
        isFilterExpanded = value.isFilterExpanded
    }

    AppScaffold(
        activityName = stringResource(id = R.string.cat_list),
        isLoading = uiState.value == ListUiState.IsLoading,
        isError = uiState.value == ListUiState.IsError
    ) {
        CardList(
            catList,
            country,
            countryList = viewModel.listOfCountries,
            setCountry = { viewModel.setCountry(it) },
            isFilterExpanded,
            toggleFilter = { viewModel.toggleFilter() }
        )
    }
}