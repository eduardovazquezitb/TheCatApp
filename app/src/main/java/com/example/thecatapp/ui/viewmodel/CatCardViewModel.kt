package com.example.thecatapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecatapp.data.datasource.CatDataSource.ApiCatDataSource
import com.example.thecatapp.data.datasource.CatDataSource.CatDataSource
import com.example.thecatapp.data.model.CatInfoDto
import com.example.thecatapp.ui.model.CatCardUiModel
import com.example.thecatapp.ui.model.mapper.toCatCardUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface CatCardUiState {
    data class Success(val catInfo: CatCardUiModel) : CatCardUiState
    object IsLoading : CatCardUiState
    object IsError : CatCardUiState
}

class CatCardViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CatCardUiState>(
        CatCardUiState.IsLoading
    )
    val uiState: StateFlow<CatCardUiState> = _uiState.asStateFlow()

    private val _dataSource : CatDataSource = ApiCatDataSource()

    fun loadCatImage(breedId : String){
        if(uiState.value is CatCardUiState.IsLoading || uiState.value is CatCardUiState.IsError)
            viewModelScope.launch {
                try{
                    val result = _dataSource.getRandomCatByBreed(breedId)
                    if(result == null)
                        setErrorState()
                    else{
                        setSuccessState(result)
                    }
                }
                catch (e: Exception){

                    setErrorState()
                }
            }
    }

    private fun setSuccessState(catInfo: CatInfoDto){
        _uiState.update {
            CatCardUiState.Success(
                catInfo.toCatCardUiModel()
            )
        }
    }

    private fun setErrorState(){
        _uiState.update {
            CatCardUiState.IsError
        }
    }
}