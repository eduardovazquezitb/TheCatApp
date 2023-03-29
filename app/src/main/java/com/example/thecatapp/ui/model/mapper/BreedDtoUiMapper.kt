package com.example.thecatapp.ui.model.mapper

import com.example.thecatapp.data.model.BreedDto
import com.example.thecatapp.ui.model.BreedUiModel

fun BreedDto.toBreedUiModel() : BreedUiModel {
    return BreedUiModel(
        id = this.id,
        name= this.name,
        description= this.description,
        country_code = this.country_code,
        temperament = this.temperament,
        wikipedia_url = this.wikipedia_url,
        catId = this.image?.url,
        url = this.image?.url
    )
}