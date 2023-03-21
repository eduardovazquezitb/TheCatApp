package com.example.thecatapp.ui.viewmodel

import com.example.thecatapp.data.CatDataSource.CatDataSource
import com.example.thecatapp.data.CatDataSource.MockCatDataSource
import com.example.thecatapp.model.CatInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ListUiState(
    val catList: List<CatInfo>,
    val isLoading: Boolean,
    val isError: Boolean
)

class ListViewModel {
    private val _uiState = MutableStateFlow<ListUiState>(
        ListUiState(
            catList = listOf(),
            isLoading = true,
            isError = false
        )
    )
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    private val _dataSource : CatDataSource = MockCatDataSource()

    fun getCatCards(){
        _uiState.update{
            ListUiState(
                _dataSource.getCats(),
                isLoading = false,
                isError = false
            )
        }
    }
}