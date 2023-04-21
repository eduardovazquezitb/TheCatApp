package com.example.thecatapp.ui.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.thecatapp.ui.activities.ListActivity
import com.example.thecatapp.ui.viewmodel.CatCardUiState
import com.example.thecatapp.ui.viewmodel.CatCardViewModel
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CatCardViewModelTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ListActivity>()

    private val viewModel = CatCardViewModel()

    @Test
    fun catCardViewModel_ViewModelStarts_StateIsLoading(){
        val uiState = viewModel.uiState

        assertTrue(uiState.value is CatCardUiState.IsLoading)
    }

    @Test
    fun catCardViewModel_loadAbyssinianImage_StateIsSuccess(){
        viewModel.loadCatImage("abys")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CatCardUiState.IsLoading
        }
        assertTrue(uiState.value is CatCardUiState.Success)
    }

    @Test
    fun catCardViewModel_loadAegeanImage_StateIsSuccess(){
        viewModel.loadCatImage("aege")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CatCardUiState.IsLoading
        }
        assertTrue(uiState.value is CatCardUiState.Success)
    }

    @Test
    fun catCardViewModel_loadRandomIdImage_StateIsError(){
        viewModel.loadCatImage("xyzt")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CatCardUiState.IsLoading
        }
        assertTrue(uiState.value is CatCardUiState.IsError)
    }

    @Test
    fun catCardViewModel_tryingToLoadAfterUnsuccesfulLoad_LoadsCorrectly(){
        viewModel.loadCatImage("xyzt")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CatCardUiState.IsLoading
        }
        viewModel.loadCatImage("abys")
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CatCardUiState.IsError
        }
        assertTrue(uiState.value is CatCardUiState.Success)
    }
}