package com.example.thecatapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.thecatapp.data.UserCredentialsChecker.MockUserCredentialsChecker
import com.example.thecatapp.data.UserCredentialsChecker.UserCredentialsChecker
import com.example.thecatapp.model.UserCredentials
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<Boolean>(false)
    val uiState: StateFlow<Boolean> = _uiState.asStateFlow()

    val username = mutableStateOf("")
    val password = mutableStateOf("")

    private val _userCredentialsChecker : UserCredentialsChecker = MockUserCredentialsChecker()

    fun CheckUserCredentials() : Boolean{
        val result = _userCredentialsChecker.isRegistered(UserCredentials(username.value, password.value))
        _uiState.value = ! result
        return result
    }
}