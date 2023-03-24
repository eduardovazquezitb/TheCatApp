package com.example.thecatapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CatInfoDto(
    val breeds: List<BreedDto>,
    val categories: List<CategoryDto>? = null,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

@Serializable
data class CategoryDto(
    val id: Int,
    val name: String
)