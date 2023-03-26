package com.example.thecatapp.ui.components.Detail

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.model.BreedDto
import com.example.thecatapp.model.CatInfoDto
import com.example.thecatapp.ui.components.CommonUsage.CountryDisplayer
import com.example.thecatapp.ui.navigation.DetailNavigator
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CatDetailDisplayer(
    breed: BreedDto,
    catInfo: CatInfoDto?,
    modifier: Modifier = Modifier
) {
    val navigator = DetailNavigator()
    val activity = LocalContext.current as Activity

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxSize()
    ){
        item{
            Spacer(modifier = modifier.padding(12.dp))
        }
        if(breed.image != null){
            item{
                GlideImage( // https://github.com/skydoves/landscapist
                    imageModel = {
                        catInfo?.url ?: breed.image.url
                    },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop
                    ),
                    modifier = modifier
                        .size(250.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            item{
                Spacer(modifier = modifier.padding(4.dp))
            }
        }
        item{
            Text(
                text = breed.name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
        }
        item{
            Spacer(modifier = modifier.padding(4.dp))
        }
        item{
            Text(
                text = breed.description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = modifier,

                )
        }
        item{
            Spacer(modifier = modifier.padding(4.dp))
        }
        item{
            CountryDisplayer(countryCode = breed.country_code)
        }
        item{
            Spacer(modifier = modifier.padding(4.dp))
        }
        item{
            Text(
                text = breed.temperament,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = modifier,
            )
        }
        item{
            Spacer(modifier = modifier.padding(4.dp))
        }
        if(breed.wikipedia_url != null){
            item{
                TextButton(
                    onClick = {
                        navigator.goToExternalLink(activity, breed.wikipedia_url)
                    }
                ){
                    Text(
                        text = breed.wikipedia_url,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = modifier,
                    )
                }
            }
            item{
                Spacer(modifier = modifier.padding(12.dp))
            }
        }
    }
}