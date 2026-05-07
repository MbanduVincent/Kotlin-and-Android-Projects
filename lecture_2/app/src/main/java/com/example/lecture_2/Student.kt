package com.example.lecture_2

class Student(val name: String, var marks: Int) {
    fun checkResult() {
        if (marks >= 50) {
            println("$name passed")
        } else {
            println("$name failed")
        }
    }
}
