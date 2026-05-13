package com.example.lecture_five

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lecture_five.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruits = listOf("Apple", "Banana", "Mango", "Orange", "Grapes")

        binding.btnLoad.setOnClickListener {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = MyAdapter(fruits)
        }
    }
}
