package com.example.thecatapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.components.ListDisplayer.ListDisplayer
import com.example.thecatapp.ui.viewmodel.ListViewModel

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : ListViewModel = viewModel()
            viewModel.getCatCards()
            ListDisplayer(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val viewModel : ListViewModel = viewModel()
    ListDisplayer(viewModel)
}