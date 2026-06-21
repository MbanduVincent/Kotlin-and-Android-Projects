package com.example.strathmorewebsite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.strathmorewebsite.ui.theme.StrathmoreWebsiteTheme
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StrathmoreWebsiteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StrathmoreScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StrathmoreScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

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
                scope.launch {
                    try {
                        val response = RetrofitClient.api.checkWebsite()

                        if (response.isSuccessful) {
                            response.body()?.close()

                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(websiteUrl)
                            )

                            context.startActivity(intent)
                        } else {
                            Toast.makeText(
                                context,
                                "Server error: ${response.code()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    } catch (e: Exception) {
                        Toast.makeText(
                            context,
                            "Retrofit check failed, opening browser directly.",
                            Toast.LENGTH_SHORT
                        ).show()

                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(websiteUrl)
                        )

                        context.startActivity(intent)
                    }
                }
            }
        ) {
            Text(text = "Open Strathmore University Website")
        }
    }
}

interface StrathmoreApi {
    @Headers("User-Agent: Mozilla/5.0")
    @GET("/")
    suspend fun checkWebsite(): Response<ResponseBody>
}

object RetrofitClient {
    private val client = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

    val api: StrathmoreApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://strathmore.edu/")
            .client(client)
            .build()
            .create(StrathmoreApi::class.java)
    }
}