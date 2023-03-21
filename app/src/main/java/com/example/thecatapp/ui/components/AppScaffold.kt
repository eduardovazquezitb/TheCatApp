package com.example.thecatapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.affirmations.ui.components.ErrorComponent
import com.example.affirmations.ui.components.Loadingcomponent
import com.example.affirmations.ui.components.TopBar
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.example.thecatapp.R

@Composable
fun AppScaffold(
    activityName: String,
    isLoading: Boolean,
    isError: Boolean,
    children: @Composable (modifier: Modifier) -> Unit,
) {

    TheCatAppTheme() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(
                activityName = 
                    if(isLoading)
                        stringResource(id = R.string.loading_title)
                    else if(isError)
                        stringResource(id = R.string.error_title)
                    else
                        activityName
            ) },
        ) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.secondary)
            ) {
                if(isLoading)
                    Loadingcomponent(modifier = Modifier.padding(padding))
                else if (isError)
                    ErrorComponent(modifier = Modifier.padding(padding))
                else
                    children(modifier= Modifier.padding(padding))
            }
        }
    }
}