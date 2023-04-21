package com.example.thecatapp.ui.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.thecatapp.ui.activities.ListActivity
import com.example.thecatapp.ui.viewmodel.ListUiState
import com.example.thecatapp.ui.viewmodel.ListViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ListViewModelTests {
    val viewModel = ListViewModel()

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ListActivity>()

    @Test
    fun listViewModel_Starts_IsLoading(){
        val uiState = viewModel.uiState

        Assert.assertTrue(uiState.value is ListUiState.IsLoading)
    }

    @Test
    fun listViewModel_LoadsBreeds_SuccessState(){
        val uiState = viewModel.uiState
        viewModel.getCatCards()

        composeTestRule.waitUntil(timeoutMillis = 10000)
        {
            uiState.value !is ListUiState.IsLoading
        }

        Assert.assertTrue(uiState.value is ListUiState.Success)
    }

    @Test
    fun listViewModel_HasLoadedSuccessfully_HasAListOfAllCountries(){
        val uiState = viewModel.uiState
        viewModel.getCatCards()

        composeTestRule.waitUntil(timeoutMillis = 10000)
        {
            uiState.value !is ListUiState.IsLoading
        }

        val successfulUi = uiState.value as ListUiState.Success
        successfulUi.catList.forEach {
            Assert.assertTrue(viewModel.listOfCountries.contains(it.country_code))
        }
    }

    @Test
    fun listViewModel_HasListOfCountries_ItsSorted(){
        val uiState = viewModel.uiState
        viewModel.getCatCards()

        composeTestRule.waitUntil(timeoutMillis = 10000)
        {
            uiState.value !is ListUiState.IsLoading
        }

        viewModel.listOfCountries.forEachIndexed{index, it ->
            if(index == 0)
                Assert.assertNull(it)
            else
                Assert.assertNotNull(it)

            if(index >= 2)
                Assert.assertTrue(viewModel.listOfCountries[index-1]!! < it!!)
        }
    }
}