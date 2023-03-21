package com.example.thecatapp.ui.components.ListDisplayer

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thecatapp.data.CatDataSource.MockCatDataSource
import com.example.thecatapp.model.CatInfo
import com.example.thecatapp.ui.navigation.ListNavigator
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CatCard (
    catInfo: CatInfo,
    modifier: Modifier = Modifier
) {
    val navigator = ListNavigator()
    val activity = LocalContext.current as Activity

    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .size(128.dp)
            .clickable { navigator.goToDetail(activity, catInfo.id) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
        ){
            Spacer(modifier=modifier.padding(start=8.dp))
            GlideImage( // https://github.com/skydoves/landscapist
                imageModel = { catInfo.url },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop
                ),
                modifier = modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = modifier.padding(start=8.dp))
            if(catInfo.breeds.size > 0)
                BreedDescription(
                    breed = catInfo.breeds[0],
                    modifier = modifier
                )
        }
    }
}

@Preview
@Composable
fun CatCardPreview(){
    TheCatAppTheme() {
        CatCard(catInfo = MockCatDataSource().getCat("33v")!!)
    }
}