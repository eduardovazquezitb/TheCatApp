package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thecatapp.model.BreedDto

@Composable
fun CardList(
    catList : List<BreedDto>,
    country : String?,
    countryList: List<String?>,
    setCountry :(String?) -> Unit,
    isFilterExpanded: Boolean,
    toggleFilter: () -> Unit,
    modifier: Modifier = Modifier
) {
    var catListDisplayed : List<BreedDto> = catList
    if(country != null)
        catListDisplayed = catListDisplayed.filter { it.country_code == country }

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        item{
            FilterByCountry(
                country,
                countryList,
                setCountry,
                isExpanded = isFilterExpanded,
                toggleExpanded = toggleFilter,
                modifier
            )
        }
        item {
            Spacer(modifier = modifier.padding(12.dp))
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
