package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.thecatapp.DetailActivity
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListNavigator {
    fun goToDetail(activity: Activity, breedDto: BreedDto, catInfoDto: CatInfoDto?){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("breed", Json.encodeToString(breedDto))
        if(catInfoDto != null)
            intent.putExtra("catinfo", Json.encodeToString(catInfoDto))
        activity.startActivity(intent)
    }
}