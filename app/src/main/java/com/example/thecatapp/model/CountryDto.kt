package com.example.thecatapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val name: NameDto? = null,
    val tld: List<String>? = null,
    val flags: FlagDto? = null
)

@Serializable
data class NameDto(
    val common: String? = null,
    val official: String? = null
)

@Serializable
data class FlagDto(
    val png: String? = null,
    val svg: String? = null,
    val alt: String? = null
)