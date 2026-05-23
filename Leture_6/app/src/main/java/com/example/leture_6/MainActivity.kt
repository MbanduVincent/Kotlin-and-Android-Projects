package com.example.leture_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.leture_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 1. Declare the binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Initialize Data Binding instead of setContentView()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 3. Bind data to the XML variable
        binding.userName = "John Doe"

        // You can also access views directly via binding
        binding.followButton.setOnClickListener {
            binding.nameText.text = "Following..."
        }
    }
}
