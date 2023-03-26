package com.example.thecatapp.ui.viewmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.thecatapp.R
import com.example.thecatapp.data.UserCredentialsChecker.MockUserCredentialsChecker
import com.example.thecatapp.data.UserCredentialsChecker.UserCredentialsChecker
import com.example.thecatapp.model.UserCredentials
import com.example.thecatapp.ui.components.Helpers.isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface LoginUiState{
    object IsOk : LoginUiState
    data class IsNotOk(@StringRes val message : Int) : LoginUiState
}

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.IsOk)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    val username = mutableStateOf("")
    val password = mutableStateOf("")

    private val _userCredentialsChecker : UserCredentialsChecker = MockUserCredentialsChecker()

    fun CheckUserCredentials() : Boolean{
        if(!username.value.isEmailValid()){
            SetNotOkState(R.string.invalid_email)
            return false
        }

        val result = _userCredentialsChecker.isRegistered(UserCredentials(username.value, password.value))
        if(! result){
            SetNotOkState(R.string.incorrect_credentials)
            return false
        }

        SetOkState()
        return true
    }

    fun SetUsername(username : String){
        this.username.value = username
    }

    fun SetPassword(password: String){
        this.password.value = password
    }

    private fun SetOkState(){
        _uiState.value = LoginUiState.IsOk
    }

    private fun SetNotOkState(message: Int){
        _uiState.update {
            LoginUiState.IsNotOk(message)
        }
    }
}