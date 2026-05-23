package com.example.practical1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practical1.ui.theme.Practical1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practical1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily.Monospace,
            color = Color.Green,
            fontSize = 30.sp,
            text = "Hello $name!"

        )
        Text(
            modifier = Modifier.padding(15.dp),
            fontFamily = FontFamily.Monospace,
            color = Color.Cyan,
            fontSize = 30.sp,
            text = "Strathmore University"
        )
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = { /* TODO */ }) {
            Text(fontSize = 30.sp,
                text = "Click Me"
            )
        }
        Button(onClick = { /* TODO */ }) {
            Text(fontSize = 30.sp,
                text = "Log in")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Practical1Theme {
            Greeting("Android")
        }
    }
}