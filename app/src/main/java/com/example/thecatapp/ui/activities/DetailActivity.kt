package com.example.thecatapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.components.Detail.DetailDisplayer
import com.example.thecatapp.ui.viewmodel.DetailViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : DetailViewModel = viewModel()
            val extras = intent.extras
            viewModel.getCatInfo(extras)

            DetailDisplayer(viewModel)
        }
    }
}