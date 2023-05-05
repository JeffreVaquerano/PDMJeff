package com.jeff.lab07.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeff.lab07.R
import com.jeff.lab07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //El binding es diferente, es necesario setiar el data
    //A diferencia ocupa muchas menos cosas y no se retorna el binding.root
    //Es para montar las vistas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}