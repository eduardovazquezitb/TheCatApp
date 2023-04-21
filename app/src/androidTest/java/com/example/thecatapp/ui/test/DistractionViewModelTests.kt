package com.example.thecatapp.ui.test

import com.example.thecatapp.ui.viewmodel.DistractionViewModel
import org.junit.Assert
import org.junit.Test

class DistractionViewModelTests {

    private val viewModel = DistractionViewModel()

    @Test
    fun distractionViewModel_ViewModelStarts_IndexIsNull(){
        val uiState = viewModel.uiState

        Assert.assertNull(uiState.value)
    }

    @Test
    fun distractionViewModel_ViewModelLoadsImage_IndexIsNotNull(){
        viewModel.loadRandomImage()
        val uiState = viewModel.uiState

        Assert.assertNotNull(uiState.value)
    }

    @Test
    fun distractionViewModel_ViewModelLoadsImageTwice_IndexStaysTheSame(){
        viewModel.loadRandomImage()
        val uiState = viewModel.uiState
        val index1 = uiState.value

        viewModel.loadRandomImage()
        val index2 = uiState.value

        Assert.assertEquals(index1, index2)
    }
}