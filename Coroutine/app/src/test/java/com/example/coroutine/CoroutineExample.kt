package com.example.coroutine

import kotlinx.coroutines.*
import org.junit.Test

class CoroutineExample {
    @Test
    fun runExample() {
        runBlocking {
            println("Loading started")
            launch {
                delay(2000)
                println("Data loaded")
            }
            println("Waiting for coroutine to finish...")
        }
    }
}