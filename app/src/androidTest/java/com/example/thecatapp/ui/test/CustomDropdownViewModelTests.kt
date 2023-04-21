package com.example.thecatapp.ui.test

import androidx.compose.material.Text
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.thecatapp.ui.activities.ListActivity
import com.example.thecatapp.ui.viewmodel.CustomDropDownItem
import com.example.thecatapp.ui.viewmodel.CustomDropDownUiState
import com.example.thecatapp.ui.viewmodel.CustomDropDownViewModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CustomDropdownViewModelTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ListActivity>()

    private val viewModel = CustomDropDownViewModel()

    private val listOfOptions = listOf<CustomDropDownItem>(
        CustomDropDownItem("first") { Text(text = "first", modifier = it) },
        CustomDropDownItem("second") { Text(text = "second", modifier = it) },
        CustomDropDownItem("third") { Text(text = "third", modifier = it) }
    )

    @Test
    fun countryDisplayerViewModel_ViewModelStarts_StateIsLoading(){
        val uiState = viewModel.uiState

        assertTrue(uiState.value is CustomDropDownUiState.IsLoading)
    }

    @Test
    fun countryDisplayerViewModel_OptionsAreLoaded_StateIsSuccess(){
        viewModel.loadListOfItems(listOfOptions)
        val uiState = viewModel.uiState

        assertTrue(uiState.value is CustomDropDownUiState.Success)
    }

    @Test
    fun countryDisplayerViewModel_StateIsSuccessful_ThereAreThreeOptions_TheFirstOneIsSelected_DropDownIsNotExpanded(){
        viewModel.loadListOfItems(listOfOptions)
        val uiState = viewModel.uiState.value as CustomDropDownUiState.Success

        assertTrue(viewModel.listOfItems.size == 3)
        assertTrue(uiState.chosenItem == listOfOptions[0].value)
        assertFalse(uiState.isExpanded)
    }

    @Test
    fun countryDisplayerViewModel_TogglingAfterSuccessfulLoad_DropdownIsExpanded(){
        viewModel.loadListOfItems(listOfOptions)
        viewModel.toggleDropdown()
        val uiState = viewModel.uiState.value as CustomDropDownUiState.Success

        assertTrue(uiState.isExpanded)
    }

    @Test
    fun countryDisplayerViewModel_TogglingBeforeLoading_StillNotSuccessful(){
        viewModel.toggleDropdown()
        val uiState = viewModel.uiState

        assertTrue(uiState.value is CustomDropDownUiState.IsLoading)
    }

    @Test
    fun countryDisplayerViewModel_TogglingAndClickingSecondElement_SecondElementIsSelected_DropdownIsNotExpanded(){
        viewModel.loadListOfItems(listOfOptions)
        viewModel.toggleDropdown()
        viewModel.onItemClick(listOfOptions[1].value)
        val uiState = viewModel.uiState.value as CustomDropDownUiState.Success

        assertTrue(uiState.chosenItem == listOfOptions[1].value)
        assertFalse(uiState.isExpanded)
    }
}