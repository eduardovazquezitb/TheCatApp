package com.example.thecatapp.data.datasource.CatDataSource

import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.data.model.CatInfoDto

interface CatDataSource {
    suspend fun getCats(number: Int) : List<CatInfoDto>
    suspend fun getCat(id: String) : CatInfoDto?
    suspend fun getRandomCatByBreed(breedId: String) : CatInfoDto?
    suspend fun getBreeds() : List<BreedDto>
}