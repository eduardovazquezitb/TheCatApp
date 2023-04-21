package com.example.thecatapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecatapp.data.datasource.CatDataSource.ApiCatDataSource
import com.example.thecatapp.data.datasource.CatDataSource.CatDataSource
import com.example.thecatapp.ui.model.BreedUiModel
import com.example.thecatapp.ui.model.mapper.toBreedUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ListUiState {
    data class Success(
        val catList: List<BreedUiModel>,
        val country: String?,
    ) : ListUiState
    object IsLoading : ListUiState
    object IsError : ListUiState
}

class ListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<ListUiState>(
        ListUiState.IsLoading
    )
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    private val _dataSource : CatDataSource = ApiCatDataSource()

    var listOfCountries : List<String?> = listOf(null)

    fun getCatCards(){
        if(_uiState.value is ListUiState.IsLoading || _uiState.value is ListUiState.IsError)
            viewModelScope.launch {
                try{
                    val result = _dataSource.getBreeds().map{ it.toBreedUiModel() }
                    listOfCountries = concatenate(
                        listOf(null),
                        result
                            .map { it.country_code }
                            .toSet()
                            .toList()
                            .sorted()
                    )

                    _uiState.update {
                        ListUiState.Success(
                            catList = result.sortedBy { it.name },
                            country = null
                        )
                    }
                } catch (e : Exception) {
                    Log.i("ERROR", e.toString())
                    setErrorState()
                }
            }
    }

    fun setCountry(chosenCountry: String?){
        if(_uiState.value is ListUiState.Success){
            _uiState.update {
                (it as ListUiState.Success).copy(
                    country = chosenCountry
                )
            }
        }
    }

    fun setErrorState(){
        _uiState.update {
            ListUiState.IsError
        }
    }

    private fun <T> concatenate(vararg lists: List<T>): List<T> {
        return listOf(*lists).flatten()
    }
}