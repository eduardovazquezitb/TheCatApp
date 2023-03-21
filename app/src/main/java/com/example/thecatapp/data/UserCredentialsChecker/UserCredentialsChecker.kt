package com.example.thecatapp.data.UserCredentialsChecker

import com.example.thecatapp.model.UserCredentials

interface UserCredentialsChecker {
    fun isRegistered(userCredentials: UserCredentials) : Boolean
}