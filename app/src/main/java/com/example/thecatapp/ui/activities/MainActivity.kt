package com.example.thecatapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.components.LogInDisplayer
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.example.thecatapp.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : MainViewModel = viewModel()
            LogInDisplayer(viewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheCatAppTheme {
        val viewModel : MainViewModel = viewModel()
        LogInDisplayer(viewModel)
    }
}