package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.data.model.CatInfoDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Path

private const val BASE_URL = "https://api.thecatapi.com/v1/"
private const val TOKEN = "live_wY5uAmAnrhUYFTU6tnTgmNxpvfkBoWSZ53yZ7SBUnbi4OlY2XaUgIE8Ogc5Q7uCF"

private val customJson = Json { ignoreUnknownKeys = true }

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(customJson.asConverterFactory("application/json".toMediaType())) // ScalarsConverterFactory.create()
    .baseUrl(BASE_URL)
    .build()

interface CatApiService {
    @GET("images/search/")
    suspend fun getCats(
        @Header("x-api-key") token: String = TOKEN,
        @Query("limit") numberOfCats: Int
    ): List<CatInfoDto>

    @GET("images/{id}/")
    suspend fun getCat(
        @Header("x-api-key") token: String = TOKEN,
        @Path("id") id: String
    ) : CatInfoDto?

    @GET("images/search/")
    suspend fun getCatByBreed(
        @Header("x-api-key") token: String = TOKEN,
        @Query("breed_ids") breedId: String
    ): List<CatInfoDto>

    @GET("breeds/")
    suspend fun getBreeds(
        @Header("x-api-key") token: String = TOKEN
    ): List<BreedDto>
}

object TheCatApi{
    val retrofitService : CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}