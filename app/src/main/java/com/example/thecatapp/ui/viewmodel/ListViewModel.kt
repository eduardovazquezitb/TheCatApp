package com.example.thecatapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecatapp.data.CatDataSource.ApiCatDataSource
import com.example.thecatapp.data.CatDataSource.CatDataSource
import com.example.thecatapp.model.BreedDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ListUiState {
    data class Success(val catList: List<BreedDto>) : ListUiState
    object IsLoading : ListUiState
    object IsError : ListUiState
}

class ListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<ListUiState>(
        ListUiState.IsLoading
    )
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    private val _dataSource : CatDataSource = ApiCatDataSource()

    fun getCatCards(){
        _uiState.value = ListUiState.IsLoading
        viewModelScope.launch {
            try{
                val result = _dataSource.getBreeds()
                _uiState.update {
                    ListUiState.Success(result.sortedBy { it.name })
                }
            } catch (e : Exception) {
                Log.i("ERROR", e.toString())
                _uiState.update {
                    ListUiState.IsError
                }
            }
        }
    }
}