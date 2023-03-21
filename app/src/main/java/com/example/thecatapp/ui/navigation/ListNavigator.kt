package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.thecatapp.DetailActivity

class ListNavigator {
    fun goToDetail(activity: Activity, id: String){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("catId", id)
        activity.startActivity(intent)
    }
}