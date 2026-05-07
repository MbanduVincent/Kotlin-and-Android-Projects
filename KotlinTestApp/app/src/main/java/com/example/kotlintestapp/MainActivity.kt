package com.example.kotlintestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    DisplayLogs()
                }
            }
        }
    }
}

@Composable
fun DisplayLogs() {
    var logs by remember { mutableStateOf(listOf("Loading started")) }

    LaunchedEffect(Unit) {
        delay(2000)
        logs = logs + "Data loaded"
        logs = logs + ("Name: " + (null ?: "Name not provided"))
    }

    Column(modifier = Modifier.padding(16.dp)) {
        logs.forEach { log ->
            Text(text = log, modifier = Modifier.padding(bottom = 4.dp))
        }
    }
}
