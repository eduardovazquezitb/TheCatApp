package com.example.thecatapp.data.datasource.UserCredentialsChecker

import com.example.thecatapp.data.model.UserCredentials

interface UserCredentialsChecker {
    fun isRegistered(userCredentials: UserCredentials) : Boolean
}