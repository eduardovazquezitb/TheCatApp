package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.data.CatDataSource.MockCatDataSource
import com.example.thecatapp.model.Breed
import com.example.thecatapp.ui.theme.TheCatAppTheme

@Composable
fun BreedDescription(
    breed: Breed,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(top = 8.dp, end = 8.dp)
            .fillMaxSize()
    ){
        Text(
            text = breed.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Spacer(modifier=modifier.padding(4.dp))
        Text(
            text = breed.description,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            modifier = modifier,
            overflow = TextOverflow.Ellipsis,
            maxLines = 4
        )
    }
}

@Preview
@Composable
fun BreedDescriptionPreview(){
    TheCatAppTheme() {
        BreedDescription(breed = MockCatDataSource().getCat("33v")!!.breeds[0])
    }
}