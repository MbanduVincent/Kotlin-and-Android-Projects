package com.example.lecture_2

import org.junit.Test

class StudentTest {
    @Test
    fun testStudentResults() {
        val student1 = Student("Alice", 75)
        val student2 = Student("John", 40)

        student1.checkResult() // Expected output: Alice passed
        student2.checkResult() // Expected output: John failed
    }
}
