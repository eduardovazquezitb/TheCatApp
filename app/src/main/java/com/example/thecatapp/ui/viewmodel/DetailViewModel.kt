package com.example.thecatapp.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.thecatapp.data.CatDataSource.CatDataSource
import com.example.thecatapp.data.CatDataSource.MockCatDataSource
import com.example.thecatapp.model.CatInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetailUiState(
    val catInfo: CatInfo?,
    val isLoading: Boolean,
    val isError: Boolean
)

class DetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(
        DetailUiState(
            catInfo = null,
            isLoading = true,
            isError = false
        )
    )
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    val catDataSource : CatDataSource = MockCatDataSource()

    fun getCatInfo(extras: Bundle?){
        if(extras == null){
            setErrorState()
            return
        }

        val id = extras.getString("catId")
        if(id == null){
            setErrorState()
            return
        }

        val catInfo = catDataSource.getCat(id)
        _uiState.update {
            DetailUiState(
                catInfo = catInfo,
                isLoading = false,
                isError = false
            )
        }
    }

    private fun setErrorState(){
        _uiState.update {
            DetailUiState(
                catInfo = null,
                isLoading = false,
                isError = true
            )
        }
    }
}