package com.example.thecatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.thecatapp.ui.components.LogInDisplayer
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.example.thecatapp.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = MainViewModel()
            LogInDisplayer(viewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TheCatAppTheme {
        LogInDisplayer(viewModel = MainViewModel())
    }
}