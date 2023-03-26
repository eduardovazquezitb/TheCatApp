package com.example.thecatapp.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CustomDropDownItem(
    val value : String?,
    val display: @Composable (Modifier) -> Unit
)

sealed interface CustomDropDownUiState{
    data class Success(
        val isExpanded: Boolean,
        val chosenItem: String?
    ) : CustomDropDownUiState
    object IsLoading : CustomDropDownUiState
}

class CustomDropDownViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CustomDropDownUiState>(
        CustomDropDownUiState.IsLoading
    )
    val uiState: StateFlow<CustomDropDownUiState> = _uiState.asStateFlow()

    var listOfItems: List<CustomDropDownItem> = listOf()
    var chosenItemComposable : @Composable (Modifier) -> Unit = { }

    fun loadListOfItems(dropDownItems: List<CustomDropDownItem>){
        if(dropDownItems.size > 0){
            listOfItems = dropDownItems
            chosenItemComposable = listOfItems[0].display
            _uiState.update{
                CustomDropDownUiState.Success(
                    isExpanded = false,
                    chosenItem = listOfItems[0].value
                )
            }
        }
    }

    fun toggleDropdown(){
        if(_uiState.value is CustomDropDownUiState.Success){
            _uiState.update {
                val state = it as CustomDropDownUiState.Success
                state.copy(
                    isExpanded = ! state.isExpanded
                )
            }
        }
    }

    fun onItemClick(value: String?){
        if(_uiState.value is CustomDropDownUiState.Success && listOfItems.filter { it.value == value }.isNotEmpty()){
            chosenItemComposable = listOfItems.first{ it.value == value }.display
            _uiState.update {
                val state = it as CustomDropDownUiState.Success
                state.copy(
                    chosenItem = value
                )
            }
        }
    }
}