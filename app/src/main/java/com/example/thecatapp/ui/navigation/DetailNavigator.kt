package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri

class DetailNavigator {
    fun goToExternalLink(activity: Activity, url: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity.startActivity(browserIntent)
    }
}