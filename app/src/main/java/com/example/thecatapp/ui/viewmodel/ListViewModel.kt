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
    data class Success(
        val catList: List<BreedDto>,
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
        _uiState.value = ListUiState.IsLoading
        viewModelScope.launch {
            try{
                val result = _dataSource.getBreeds()
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
                _uiState.update {
                    ListUiState.IsError
                }
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

    private fun <T> concatenate(vararg lists: List<T>): List<T> {
        return listOf(*lists).flatten()
    }
}