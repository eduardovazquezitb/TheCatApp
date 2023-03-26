package com.example.thecatapp.ui.components.CommonUsage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoadingDropDown(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        ExposedDropdownMenuBox(
            expanded = false,
            onExpandedChange = {  },
            modifier = modifier.fillMaxWidth()
        ) {

        }
    }
}