package com.example.thecatapp.data.CatDataSource

import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto
import com.example.thecatapp.model.WeightDto

@Suppress("unused")
class MockCatDataSource : CatDataSource {
    private val _breed : BreedDto =
        BreedDto(
            weight = WeightDto(imperial="7 - 11",metric="3 - 5"),
            id="nebe",
            name="Nebelung",
            temperament="Gentle, Quiet, Shy, Playful",
            origin="United States",
            country_codes="US",
            country_code="US",
            description="The Nebelung may have a reserved nature, but she loves to play (being especially fond of retrieving) and enjoys jumping or climbing to high places where she can study people and situations at her leisure before making up her mind about whether she wants to get involved.",
            life_span="11 - 16",
            indoor=0,
            lap=1,
            alt_names="Longhaired Russian Blue",
            adaptability=5,
            affection_level=5,
            child_friendly=4,
            dog_friendly=4,
            energy_level=3,
            grooming=3,
            health_issues=2,
            intelligence=5,
            shedding_level=3,
            social_needs=3,
            stranger_friendly=3,
            vocalisation=1,
            experimental=0,
            hairless=0,
            natural=0,
            rare=1,
            rex=0,
            suppressed_tail=0,
            short_legs=0,
            wikipedia_url="https://en.wikipedia.org/wiki/Nebelung",
            hypoallergenic=0,
            reference_image_id="OGTWqNNOt"
        )

    private val _catList : List<CatInfoDto> = listOf(
        CatInfoDto(breeds= listOf(_breed), id="33v",url="https://cdn2.thecatapi.com/images/33v.gif",width=200,height=234),
        CatInfoDto(breeds= listOf(_breed),id="3da",url="https://cdn2.thecatapi.com/images/3da.jpg",width=720,height=533),
        CatInfoDto(breeds= listOf(_breed),id="6v5",url="https://cdn2.thecatapi.com/images/6v5.jpg",width=1024,height=600),
        CatInfoDto(breeds= listOf(_breed),id="add",url="https://cdn2.thecatapi.com/images/add.jpg",width=640, height=426),
        CatInfoDto(breeds= listOf(_breed),id="bqr",url="https://cdn2.thecatapi.com/images/bqr.jpg",width=800, height=533),
        CatInfoDto(breeds= listOf(_breed),id="ces",url="https://cdn2.thecatapi.com/images/ces.jpg",width=667, height = 1000),
        CatInfoDto(breeds= listOf(_breed),id="dlo",url="https://cdn2.thecatapi.com/images/dlo.jpg",width=640, height = 426),
        CatInfoDto(breeds= listOf(_breed),id="ef5",url="https://cdn2.thecatapi.com/images/ef5.jpg",width=500, height=281),
        CatInfoDto(breeds= listOf(_breed),id="y61B6bFCh",url="https://cdn2.thecatapi.com/images/y61B6bFCh.jpg", width = 898, height = 900),
        CatInfoDto(breeds= listOf(_breed),id="ohy1YBZtD",url="https://cdn2.thecatapi.com/images/ohy1YBZtD.png", width = 1920, height = 1080)
    )

    override suspend fun getCats(number: Int): List<CatInfoDto> {
        return _catList.filterIndexed { index, _ -> index < number }
    }

    override suspend fun getCat(id: String): CatInfoDto? {
        for(i in 0.._catList.size-1){
            if(_catList[i].id == id)
                return _catList[i]
        }
        return null
    }

    override suspend fun getBreeds(): List<BreedDto> {
        return listOf(_breed)
    }
}