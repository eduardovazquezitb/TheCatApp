package com.example.thecatapp.ui.viewmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.thecatapp.R
import com.example.thecatapp.ui.components.Helpers.IsPasswordWellFormatted
import com.example.thecatapp.ui.components.Helpers.isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface RegisterUiState{
    object IsOk : RegisterUiState
    data class IsNotOk(
        @StringRes val message : Int,
        val parameter: String = ""
    ) : RegisterUiState
}


class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.IsOk)
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    val username = mutableStateOf("")
    val password = mutableStateOf("")

    fun CheckUserCredentials(): Boolean {
        if (!username.value.isEmailValid()) {
            SetNotOkState(R.string.invalid_email)
            return false
        }

        val result = password.value.IsPasswordWellFormatted()
        if(! result.isOk && result.message != null){
            SetNotOkState(result.message, result.parameter)
            return false
        }

        SetOkState()
        return true
    }

    fun SetUsername(username: String) {
        this.username.value = username
    }

    fun SetPassword(password: String) {
        this.password.value = password
    }

    private fun SetOkState() {
        _uiState.value = RegisterUiState.IsOk
    }

    private fun SetNotOkState(message: Int, parameter: String = "") {
        _uiState.update {
            RegisterUiState.IsNotOk(
                message = message,
                parameter = parameter
            )
        }
    }
}