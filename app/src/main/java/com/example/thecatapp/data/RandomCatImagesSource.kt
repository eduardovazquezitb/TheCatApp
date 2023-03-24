package com.example.thecatapp.data

import com.example.thecatapp.R
import kotlin.random.Random

class RandomCatImagesSource {

    private val _listOfStaticCats : List<Int> = // https://cdn2.thecatapi.com/images/ +
        listOf(
            R.drawable.cat1rd,
            R.drawable.cat2gq,
            R.drawable.cat2k4,
            R.drawable.cat3sm,
            R.drawable.cat4u8,
            R.drawable.cat6rj,
            R.drawable.cat7ka,
            R.drawable.cat9qi,
            R.drawable.catb4b
        )

    private val _listOfAnimatedCats : List<Int> =
        listOf(
            R.drawable.cat4gm,
            R.drawable.cat4c3,
            R.drawable.cat4rh,
            R.drawable.cat83r,
            R.drawable.catale,
        )

    fun getRandomCatImage() : Int {
        val index = Random.nextInt(_listOfStaticCats.size)
        return _listOfStaticCats[index]
    }

    fun getRandomAnimatedCat() : Int {
        val index = Random.nextInt(_listOfAnimatedCats.size)
        return _listOfAnimatedCats[index]
    }
}