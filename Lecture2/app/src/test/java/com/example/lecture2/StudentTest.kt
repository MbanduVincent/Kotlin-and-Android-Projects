package com.example.lecture2

import org.junit.Test

class StudentTest {
    @Test
    fun testStudentResults() {
        val student1 = Student("Alice", 75)
        val student2 = Student("John", 40)

        student1.checkResult()
        student2.checkResult()
    }
}