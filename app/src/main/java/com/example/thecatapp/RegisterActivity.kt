package com.example.thecatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thecatapp.ui.components.RegisterDisplayer
import com.example.thecatapp.ui.theme.TheCatAppTheme
import com.example.thecatapp.ui.viewmodel.RegisterViewModel

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : RegisterViewModel = viewModel()
            RegisterDisplayer(viewModel)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    TheCatAppTheme {
        Greeting("Android")
    }
}