package com.example.thecatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thecatapp.ui.components.Detail.DetailDisplayer
import com.example.thecatapp.ui.viewmodel.DetailViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = DetailViewModel()
            val extras = intent.extras
            viewModel.getCatInfo(extras)

            DetailDisplayer(viewModel = viewModel)
        }
    }
}