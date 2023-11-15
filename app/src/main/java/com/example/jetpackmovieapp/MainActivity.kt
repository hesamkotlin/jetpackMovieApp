package com.example.jetpackmovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackmovieapp.ui.theme.JetPackMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp {
                mainContent()
            }
        }
    }
}

@Composable
fun myApp(content: @Composable () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text("Movies")
        }

    }) {
        content()
    }
}

@Composable
fun mainContent() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "hello")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    myApp {
        Text(text = "hello")
    }
}