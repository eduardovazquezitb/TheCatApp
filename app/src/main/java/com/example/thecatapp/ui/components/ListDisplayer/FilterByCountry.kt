package com.example.thecatapp.ui.components.ListDisplayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thecatapp.ui.components.CommonUsage.CountryDisplayer

// Overridden by generic Component CustomDropDown

@Suppress("unused")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterByCountry(
    country: String?,
    countryList: List<String?>,
    setCountry :(String?) -> Unit,
    isExpanded: Boolean,
    toggleExpanded: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
    {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { toggleExpanded() },
            modifier = modifier.fillMaxWidth()
        ) {
            TextField(
                value = country ?: "None",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                modifier = modifier.fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { if(isExpanded) toggleExpanded() },
                modifier = modifier
            ) {

                countryList.forEachIndexed { _, itemValue ->
                    DropdownMenuItem(
                        onClick = {
                            setCountry(itemValue)
                            toggleExpanded()
                        },
                        modifier.fillMaxWidth()
                    ) {
                        if(itemValue == null)
                            Text(
                                text = "None",
                                modifier = modifier.fillMaxWidth()
                            )
                        else
                            CountryDisplayer(countryCode = itemValue)
                    }
                }
            }
        }
    }
}