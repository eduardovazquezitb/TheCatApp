package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.thecatapp.ListActivity

class MainNavigator {
    fun goToListDisplay(activity : Activity){
        val intent = Intent(activity, ListActivity::class.java)
        activity.startActivity(intent)
    }
}