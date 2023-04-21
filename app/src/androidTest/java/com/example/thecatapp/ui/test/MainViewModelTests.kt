package com.example.thecatapp.ui.test

import com.example.thecatapp.R
import com.example.thecatapp.data.model.UserCredentials
import com.example.thecatapp.ui.viewmodel.LoginUiState
import com.example.thecatapp.ui.viewmodel.MainViewModel
import org.junit.Assert
import org.junit.Test

class MainViewModelTests {
    val viewModel = MainViewModel()

    val correctCredentials = UserCredentials(username = "a@gmail.com", password = "")

    @Test
    fun mainViewModel_Starts_StateIsOk(){
        val uiState = viewModel.uiState

        Assert.assertTrue(uiState.value is LoginUiState.IsOk)
    }

    @Test
    fun mainViewModel_UsesCorrectCredentials_StateIsOk(){
        val uiState = viewModel.uiState

        viewModel.SetUsername(correctCredentials.username)
        viewModel.SetPassword(correctCredentials.password)

        val result = viewModel.CheckUserCredentials()

        Assert.assertTrue(result)
        Assert.assertTrue(uiState.value is LoginUiState.IsOk)
    }

    @Test
    fun mainViewModel_UsesIncorrectPassword_StateIsNotOk(){
        val uiState = viewModel.uiState

        viewModel.SetUsername(correctCredentials.username)
        viewModel.SetPassword(correctCredentials.password + "413")

        val result = viewModel.CheckUserCredentials()

        Assert.assertFalse(result)
        Assert.assertTrue(uiState.value is LoginUiState.IsNotOk)
        Assert.assertTrue((uiState.value as LoginUiState.IsNotOk).message == R.string.incorrect_credentials)
    }

    @Test
    fun mainViewModel_UsesBadFormattedEmail_StateIsNotOk(){
        val uiState = viewModel.uiState

        viewModel.SetUsername("pepe.json")
        viewModel.SetPassword(correctCredentials.password)

        val result = viewModel.CheckUserCredentials()

        Assert.assertFalse(result)
        Assert.assertTrue(uiState.value is LoginUiState.IsNotOk)
        Assert.assertTrue((uiState.value as LoginUiState.IsNotOk).message == R.string.invalid_email)
    }
}
