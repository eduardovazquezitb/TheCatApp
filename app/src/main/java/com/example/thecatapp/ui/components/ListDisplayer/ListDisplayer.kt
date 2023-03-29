package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thecatapp.R
import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.ui.components.AppScaffold
import com.example.thecatapp.ui.components.CommonUsage.CountryDisplayer
import com.example.thecatapp.ui.components.CommonUsage.TheWorld
import com.example.thecatapp.ui.model.BreedUiModel
import com.example.thecatapp.ui.viewmodel.CustomDropDownItem
import com.example.thecatapp.ui.viewmodel.ListUiState
import com.example.thecatapp.ui.viewmodel.ListViewModel

@Composable
fun ListDisplayer(
    viewModel : ListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    var catList : List<BreedUiModel> = listOf()
    var country : String? = null

    if(uiState.value is ListUiState.Success){
        val value = uiState.value as ListUiState.Success
        catList = value.catList
        country = value.country
    }

    AppScaffold(
        activityName = stringResource(id = R.string.cat_list),
        isLoading = uiState.value == ListUiState.IsLoading,
        isError = uiState.value == ListUiState.IsError,
        onTryAgainClick = { viewModel.getCatCards() }
    ) { modifier ->
        CardLazyColumn(
            catList,
            country,
            modifier,
            header = { headerModifier ->
                CustomDropDown(
                    dropDownItems = viewModel.listOfCountries.map {
                        if(it == null)
                            CustomDropDownItem(null) { modifier -> TheWorld(modifier) }
                        else
                            CustomDropDownItem(it) { modifier -> CountryDisplayer(it, modifier) }
                    },
                    onClickedItem = { viewModel.setCountry(it) },
                    modifier = headerModifier,
                    width = 240.dp
                )
            }
        )
    }
}