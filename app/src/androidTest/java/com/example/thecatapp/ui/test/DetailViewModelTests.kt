package com.example.thecatapp.ui.test

import android.os.Bundle
import com.example.thecatapp.data.datasource.CatDataSource.MockCatDataSource
import com.example.thecatapp.ui.model.mapper.toBreedUiModel
import com.example.thecatapp.ui.model.mapper.toCatCardUiModel
import com.example.thecatapp.ui.viewmodel.DetailUiState
import com.example.thecatapp.ui.viewmodel.DetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTests {

    private val viewModel = DetailViewModel()

    private val dataSource = MockCatDataSource()

    private val bundle = Bundle()

    @Test
    fun detailViewModel_ViewModelStarts_ViewModelIsLoading(){
        val uiState = viewModel.uiState

        Assert.assertTrue(uiState.value is DetailUiState.IsLoading)
    }

    @Test
    fun detailViewModel_ViewModelLoadsEmptyBundle_SetsErrorState(){
        viewModel.getCatInfo(bundle)
        val uiState = viewModel.uiState

        Assert.assertTrue(uiState.value is DetailUiState.IsError)
    }

    @Test
    fun detailViewModel_ViewModelLoadsCatInfo_SetsSuccessState() = runTest{
        val catInfo = dataSource.getCat("33v")?.toCatCardUiModel()
        val breedInfo = dataSource.getBreeds().get(0).toBreedUiModel()

        bundle.putString("catinfo", Json.encodeToString(catInfo))
        bundle.putString("breed", Json.encodeToString(breedInfo))

        viewModel.getCatInfo(bundle)
        val uiState = viewModel.uiState

        Assert.assertTrue(uiState.value is DetailUiState.Success)
    }
}