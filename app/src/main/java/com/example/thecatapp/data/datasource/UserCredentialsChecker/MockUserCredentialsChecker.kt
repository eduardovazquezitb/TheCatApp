package com.example.thecatapp.data.datasource.UserCredentialsChecker

import com.example.thecatapp.data.model.UserCredentials

class MockUserCredentialsChecker : UserCredentialsChecker {

    private val _listOfUsers = mutableListOf<UserCredentials>(
        UserCredentials("a@gmail.com", "")
    )

    override fun isRegistered(userCredentials: UserCredentials): Boolean {
        return _listOfUsers.contains(userCredentials)
    }
}