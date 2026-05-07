package com.example.controlflow

import org.junit.Test

class Box<T>(var value: T)

class BoxTest {

    @Test
    fun testBox() {
        val intBox = Box(10)
        val stringBox = Box("Hello")

        println(intBox.value)
        println(stringBox.value)
    }
}