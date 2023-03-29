package com.example.thecatapp.ui.model

@kotlinx.serialization.Serializable
data class BreedUiModel (
    val id: String,
    val name: String,
    val description: String,
    val country_code: String,
    val temperament: String,
    val wikipedia_url: String?,
    val url : String?,
    val catId: String?
)