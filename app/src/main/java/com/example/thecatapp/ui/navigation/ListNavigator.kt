package com.example.thecatapp.ui.navigation

import android.app.Activity
import android.content.Intent
import com.example.thecatapp.ui.activities.DetailActivity
import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.data.model.CatInfoDto
import com.example.thecatapp.ui.model.BreedUiModel
import com.example.thecatapp.ui.model.CatCardUiModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListNavigator {
    fun goToDetail(activity: Activity, breedDto: BreedUiModel, catInfoDto: CatCardUiModel?){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("breed", Json.encodeToString(breedDto))
        if(catInfoDto != null)
            intent.putExtra("catinfo", Json.encodeToString(catInfoDto))
        activity.startActivity(intent)
    }
}