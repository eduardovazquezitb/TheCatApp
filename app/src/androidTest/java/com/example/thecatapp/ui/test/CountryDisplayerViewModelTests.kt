package com.example.thecatapp.ui.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.thecatapp.ui.activities.ListActivity
import com.example.thecatapp.ui.viewmodel.CountryDisplayerUiState
import com.example.thecatapp.ui.viewmodel.CountryDisplayerViewModel
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CountryDisplayerViewModelTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ListActivity>()

    private val viewModel = CountryDisplayerViewModel()

    @Test
    fun countryDisplayerViewModel_ViewModelStarts_StateIsLoading(){
        val uiState = viewModel.uiState

        assertTrue(uiState.value is CountryDisplayerUiState.IsLoading)
    }

    @Test
    fun countryDisplayerViewModel_loadBelgiumFlag_StateIsSuccess(){
        viewModel.loadCountry("BE")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CountryDisplayerUiState.IsLoading
        }
        assertTrue(uiState.value is CountryDisplayerUiState.Success)
    }

    @Test
    fun countryDisplayerViewModel_loadRandomIfFlag_StateIsError(){
        viewModel.loadCountry("zz3")
        val uiState = viewModel.uiState
        composeTestRule.waitUntil(
            timeoutMillis = 10000
        ) {
            uiState.value !is CountryDisplayerUiState.IsLoading
        }
        assertTrue(uiState.value is CountryDisplayerUiState.IsError)
    }
}