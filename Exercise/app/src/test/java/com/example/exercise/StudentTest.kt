package com.example.exercise

import org.junit.Test

class StudentTest {
    @Test
    fun testStudentResults() {
        val student1 = Student("Alice", 75)
        val student2 = Student("John", 40)

        student1.checkResult() // Expected output in console: Alice passed
        student2.checkResult() // Expected output in console: John failed
    }
}
