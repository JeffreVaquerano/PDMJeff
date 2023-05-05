package com.jeff.lab07.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeff.lab07.R
import com.jeff.lab07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}