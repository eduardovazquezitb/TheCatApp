package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto


class ApiCatDataSource : CatDataSource {
    override suspend fun getCats(number: Int): List<CatInfoDto> {
        return TheCatApi.retrofitService.getCats(numberOfCats = number)
    }

    override suspend fun getCat(id: String): CatInfoDto? {
        return try{
            TheCatApi.retrofitService.getCat(id = id)
        } catch(e : Exception){
            null
        }
    }

    override suspend fun getRandomCatByBreed(breedId: String): CatInfoDto? {
        val result = TheCatApi.retrofitService.getCatByBreed(breedId = breedId)
        if(result.isEmpty())
            return null
        return result[0]
    }

    override suspend fun getBreeds(): List<BreedDto> {
        return TheCatApi.retrofitService.getBreeds()
    }
}