package com.example.lecture_8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val item1 = findViewById<TextView>(R.id.item1)
        val item2 = findViewById<TextView>(R.id.item2)
        val item3 = findViewById<TextView>(R.id.item3)
        val item4 = findViewById<TextView>(R.id.item4)
        val item5 = findViewById<TextView>(R.id.item5)
        val item6 = findViewById<TextView>(R.id.item6)
        val detailText = findViewById<TextView>(R.id.detailText)
        item1.setOnClickListener{
            detailText.text = "Item 1 detail"
        }
        item2.setOnClickListener {
            detailText.text = "Item 2 detail"
        }
        item3.setOnClickListener {
            detailText.text = "Item 3 detail"
        }
        item4.setOnClickListener {
            detailText.text = "Item 4 detail"
        }
        item5.setOnClickListener {
            detailText.text = "Item 5 detail"
        }
        item6.setOnClickListener {
            detailText.text = "Item 6 detail"
        }
    }
    }
