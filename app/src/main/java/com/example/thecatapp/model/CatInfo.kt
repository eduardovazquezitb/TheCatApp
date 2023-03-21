package com.example.thecatapp.model

data class CatInfo(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)

data class Breed(
    val adaptability: Int,
    val affection_level: Int,
    val alt_names: String,
    val cfa_url: String? = null,
    val child_friendly: Int,
    val country_code: String,
    val country_codes: String,
    val description: String,
    val dog_friendly: Int,
    val energy_level: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    val health_issues: Int,
    val hypoallergenic: Int,
    val id: String,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    val life_span: String,
    val name: String,
    val natural: Int,
    val origin: String,
    val rare: Int,
    val reference_image_id: String,
    val rex: Int,
    val shedding_level: Int,
    val short_legs: Int,
    val social_needs: Int,
    val stranger_friendly: Int,
    val suppressed_tail: Int,
    val temperament: String,
    val vcahospitals_url: String? = null,
    val vetstreet_url: String? = null,
    val vocalisation: Int,
    val weight: Weight,
    val wikipedia_url: String
)

data class Weight(
    val imperial: String,
    val metric: String
)