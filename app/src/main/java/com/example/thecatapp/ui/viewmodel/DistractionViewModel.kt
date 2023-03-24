package com.example.thecatapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.thecatapp.data.RandomCatImagesSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DistractionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<Int?>(null)

    val uiState : StateFlow<Int?> = _uiState.asStateFlow()

    private val _dataSource = RandomCatImagesSource()

    fun loadRandomImage(){
        _uiState.value = _dataSource.getRandomCatImage()
    }

    fun loadRandomAnimation(){
        _uiState.value = _dataSource.getRandomAnimatedCat()
    }
}