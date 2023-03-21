package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecatapp.data.CatDataSource.MockCatDataSource
import com.example.thecatapp.model.CatInfo
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CatCard (
    catInfo: CatInfo,
    onClick: ((String)->Unit)? = null,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondaryVariant,
        //onClick = {  },
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .size(128.dp)
            .clickable { if (onClick != null) onClick(catInfo.id) }
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