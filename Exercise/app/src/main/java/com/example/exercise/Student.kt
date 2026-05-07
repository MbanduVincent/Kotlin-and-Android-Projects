package com.example.exercise

class Student(val name: String, var marks: Int) {
    fun checkResult() {
        if (marks >= 50) {
            println("$name passed")
        } else {
            println("$name failed")
        }
    }
}
