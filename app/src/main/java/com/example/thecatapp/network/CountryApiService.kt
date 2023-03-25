package com.example.thecatapp.network

import com.example.thecatapp.model.CountryDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Path

private const val BASE_URL = "https://restcountries.com/v3.1/"

private val customJson = Json { ignoreUnknownKeys = true }

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(customJson.asConverterFactory("application/json".toMediaType())) // ScalarsConverterFactory.create()
    .baseUrl(BASE_URL)
    .build()

interface CountryApiService {
    @GET("alpha/{code}/")
    suspend fun getCountryByCode(
        @Path("code") code: String
    ) : List<CountryDto>
}

object CountryApi{
    val retrofitService : CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
    }
}
