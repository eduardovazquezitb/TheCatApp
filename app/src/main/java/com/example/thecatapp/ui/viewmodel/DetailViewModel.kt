package com.example.thecatapp.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.data.model.CatInfoDto
import com.example.thecatapp.ui.model.BreedUiModel
import com.example.thecatapp.ui.model.CatCardUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

sealed interface DetailUiState{
    data class Success(
        val breed: BreedUiModel,
        val catInfo: CatCardUiModel?
    ) : DetailUiState
    object IsLoading : DetailUiState
    object IsError : DetailUiState
}

class DetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(
       DetailUiState.IsLoading
    )
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun getCatInfo(extras: Bundle?){
        if(_uiState.value is DetailUiState.IsLoading || _uiState.value is DetailUiState.IsError){
            if(extras == null){
                setErrorState()
                return
            }

            val breed = extras.getString("breed")
            if(breed == null){
                setErrorState()
                return
            }

            var catInfo : CatCardUiModel? = null
            val catInfoString = extras.getString("catinfo")
            if(catInfoString != null){
                catInfo = Json.decodeFromString<CatCardUiModel>(catInfoString)
            }

            val breedDto = Json.decodeFromString<BreedUiModel>(breed)

            _uiState.update {
                DetailUiState.Success(
                    breedDto,
                    catInfo
                )
            }
        }
    }

    private fun setErrorState(){
        _uiState.update {
            DetailUiState.IsError
        }
    }
}