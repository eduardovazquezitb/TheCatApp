package com.example.thecatapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecatapp.data.CountryDataSource
import com.example.thecatapp.model.CountryDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface CountryDisplayerUiState {
    data class Success(val country: CountryDto) : CountryDisplayerUiState
    object IsLoading : CountryDisplayerUiState
    object IsError : CountryDisplayerUiState
}

class CountryDisplayerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CountryDisplayerUiState>(
        CountryDisplayerUiState.IsLoading
    )
    val uiState: StateFlow<CountryDisplayerUiState> = _uiState.asStateFlow()

    private val _dataSource = CountryDataSource()

    fun loadCountry(code : String){
        viewModelScope.launch {
            try{
                val result = _dataSource.getCountryByCode(code)
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

    private fun setSuccessState(country: CountryDto){
        _uiState.update {
            CountryDisplayerUiState.Success(
                country
            )
        }
    }

    private fun setErrorState(){
        _uiState.update {
            CountryDisplayerUiState.IsError
        }
    }
}