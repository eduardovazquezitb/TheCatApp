package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto


class ApiCatDataSource : CatDataSource {
    override suspend fun getCats(number: Int): List<CatInfoDto> {
        return TheCatApi.retrofitService.getCats(numberOfCats = number)
    }

    override suspend fun getCat(id: String): CatInfoDto? {
        return TheCatApi.retrofitService.getCat(id = id)
    }

    override suspend fun getBreeds(): List<BreedDto> {
        return TheCatApi.retrofitService.getBreeds()
    }
}