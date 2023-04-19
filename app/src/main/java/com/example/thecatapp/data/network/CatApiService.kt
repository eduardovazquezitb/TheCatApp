package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.data.model.CatInfoDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.*

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
    @Headers("x-api-key: $TOKEN")
    suspend fun getCats(
        @Query("limit") numberOfCats: Int
    ): List<CatInfoDto>

    @GET("images/{id}/")
    @Headers("x-api-key: $TOKEN")
    suspend fun getCat(
        @Path("id") id: String
    ) : CatInfoDto?

    @GET("images/search/")
    @Headers("x-api-key: $TOKEN")
    suspend fun getCatByBreed(
        @Query("breed_ids") breedId: String
    ): List<CatInfoDto>

    @GET("breeds/")
    @Headers("x-api-key: $TOKEN")
    suspend fun getBreeds(
    ): List<BreedDto>
}

object TheCatApi{
    val retrofitService : CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}