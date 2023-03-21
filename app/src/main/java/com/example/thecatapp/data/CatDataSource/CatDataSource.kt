package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.model.CatInfo

interface CatDataSource {
    fun getCats() : List<CatInfo>
    fun getCat(id: String) : CatInfo?
}