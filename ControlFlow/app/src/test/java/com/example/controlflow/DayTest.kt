package com.example.controlflow

import org.junit.Test

class DayTest {

    @Test
    fun testDay() {
        val day = 2

        when (day) {
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            else -> println("Invalid")
        }
    }
}

