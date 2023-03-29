package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.thecatapp.ui.activities.ListActivity
import com.example.thecatapp.ui.activities.RegisterActivity

class MainNavigator {
    fun goToListDisplay(activity : Activity){
        val intent = Intent(activity, ListActivity::class.java)
        activity.startActivity(intent)
    }

    fun goToRegisterDisplay(activity: Activity){
        val intent = Intent(activity, RegisterActivity::class.java)
        activity.startActivity(intent)
    }
}