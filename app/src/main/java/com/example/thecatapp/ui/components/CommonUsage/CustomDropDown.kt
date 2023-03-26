package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.thecatapp.ui.viewmodel.CustomDropDownItem
import com.example.thecatapp.ui.viewmodel.CustomDropDownViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.components.CommonUsage.LoadingDropDown
import com.example.thecatapp.ui.viewmodel.CustomDropDownUiState

@Composable
fun CustomDropDown(
    dropDownItems: List<CustomDropDownItem>,
    modifier: Modifier = Modifier,
    onClickedItem: ((String?) -> Unit)? = null,
    width: Dp = 180.dp,
    key: String? = null,
    viewModel: CustomDropDownViewModel = viewModel(key = key)
) {
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(dropDownItems){
        viewModel.loadListOfItems(dropDownItems)
    }

    if(uiState.value is CustomDropDownUiState.IsLoading){
        LoadingDropDown()
        return
    }

    val state = (uiState.value as CustomDropDownUiState.Success)

    Row(
        modifier = modifier.fillMaxWidth()
    ){
        IconButton(
            onClick = { viewModel.toggleDropdown() },
            modifier = modifier
                .padding(start= 16.dp, end=8.dp)
        ) {
            viewModel.chosenItemComposable(modifier)
        }

        Box(
            modifier = modifier
                .padding(start= 8.dp)
                .width(width)
        )
        {
            DropdownMenu(
                expanded = state.isExpanded,
                onDismissRequest = { if(state.isExpanded) viewModel.toggleDropdown() },
                modifier = modifier.width(width)
            ) {

                viewModel.listOfItems.forEachIndexed { itemIndex, itemValue ->
                    DropdownMenuItem(
                        onClick = {
                            if(onClickedItem != null)
                                onClickedItem(itemValue.value)
                            viewModel.onItemClick(itemValue.value)
                            viewModel.toggleDropdown()
                        },
                        modifier.fillMaxWidth()
                    ) {
                        itemValue.display(modifier)
                    }
                }
            }
        }
    }
}
