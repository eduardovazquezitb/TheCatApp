package com.example.affirmations.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TopBar(
    activityName: String,
    modifier : Modifier = Modifier,
    topBarComponents: List<@Composable ((Modifier)->Unit)> = listOf(),
) {
    TopAppBar(
        /*navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = com.example.temtemreference.R.drawable.logo),
                    contentDescription = stringResource(id = com.example.temtemreference.R.string.app_name),
                    tint = Color.Unspecified,
                    modifier = modifier.clickable { onGoBackClick!!() }
                )
            }
        },*/
        title = {
            Text(
                text = activityName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = modifier
                /*.clickable {  }*/
            ) },
        actions = {
            /*
            if(onGoBackButton != null){
                IconButton(onClick = { onGoBackButton() } ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = stringResource(id = R.string.change_theme)
                    )
                }
            }
            if(onThemeClick != null){
                IconButton(onClick = { onThemeClick() } ) {
                    Icon(
                        imageVector = Icons.Filled.FormatPaint,
                        contentDescription = stringResource(id = R.string.change_theme)
                    )
                }
            }
            */
            topBarComponents.map {
                it(modifier)
            }
        }
    )
}
