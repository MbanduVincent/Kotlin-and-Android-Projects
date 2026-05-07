package com.example.controlflow

import org.junit.Test

class LoopTest {

    @Test
    fun testLoop() {
        var i = 1
        while(i <= 5)
        {
            println(i)
            i++
        }

    }
}