package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thecatapp.model.BreedDto

@Composable
fun CardLazyColumn(
    catList : List<BreedDto>,
    country : String?,
    modifier: Modifier = Modifier,
    header: (@Composable (Modifier) -> Unit)? = null
) {
    var catListDisplayed : List<BreedDto> = catList
    if(country != null)
        catListDisplayed = catListDisplayed.filter { it.country_code == country }

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ){
        if(header != null){
            item{
                Spacer(modifier = modifier.padding(4.dp))
            }
            item{
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ){
                    header(modifier)
                }
            }
            item{
                Spacer(modifier = modifier.padding(4.dp))
            }
        }
        this.items(
            items = catListDisplayed,
            itemContent = {item ->
            CatCard(
                item
            )
        })
    }
}
