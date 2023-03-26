package com.example.thecatapp.data.UserCredentialsChecker

import com.example.thecatapp.model.UserCredentials

class MockUserCredentialsChecker : UserCredentialsChecker {

    private val _listOfUsers = mutableListOf<UserCredentials>(
        UserCredentials("a@gmail.com", "")
    )

    override fun isRegistered(userCredentials: UserCredentials): Boolean {
        return _listOfUsers.contains(userCredentials)
    }
}