package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thecatapp.model.BreedDto

@Composable
fun CardList(
    catList : List<BreedDto>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        this.items(items = catList, itemContent = {item ->
            CatCard(
                item
            )
        })
    }
}
