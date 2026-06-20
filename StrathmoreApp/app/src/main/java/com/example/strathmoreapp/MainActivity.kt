package com.example.strathmoreapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.strathmoreapp.ui.theme.StrathmoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StrathmoreAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StrathmoreScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun StrathmoreScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val websiteUrl = "https://strathmore.edu/"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "Could not open browser. Please ensure a browser is installed.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        ) {
            Text(text = "Open Strathmore University Website")
        }
    }
}