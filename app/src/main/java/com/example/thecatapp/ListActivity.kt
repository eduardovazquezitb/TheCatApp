package com.example.thecatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.thecatapp.ui.components.ListDisplayer.ListDisplayer
import com.example.thecatapp.ui.viewmodel.ListViewModel

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ListViewModel()
            viewModel.getCatCards()
            ListDisplayer(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ListDisplayer(viewModel = ListViewModel())
}