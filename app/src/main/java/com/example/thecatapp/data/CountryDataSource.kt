package com.example.thecatapp.data

import com.example.thecatapp.model.CountryDto
import com.example.thecatapp.network.CountryApi

class CountryDataSource {
    suspend fun getCountryByCode(code: String) : CountryDto? {
        var queryCode = code
        if(code == "SP")
            queryCode = "SG" // the Cat API has the wrong code for some reason
        val result = CountryApi.retrofitService.getCountryByCode(queryCode)
        if(result.isEmpty())
            return null
        return result[0]
    }
}