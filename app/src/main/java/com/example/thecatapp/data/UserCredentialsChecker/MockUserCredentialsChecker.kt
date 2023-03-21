package com.example.thecatapp.data.UserCredentialsChecker

import com.example.thecatapp.data.UserCredentialsChecker.UserCredentialsChecker
import com.example.thecatapp.model.UserCredentials

class MockUserCredentialsChecker : UserCredentialsChecker {

    private val listOfUsers = mutableListOf<UserCredentials>(
        UserCredentials("ivan", "gatosCuquis314"),
        UserCredentials("jefa", "b4sk3t"),
        UserCredentials("edu", "2718281828")
    )

    override fun isRegistered(userCredentials: UserCredentials): Boolean {
        return listOfUsers.contains(userCredentials)
    }
}