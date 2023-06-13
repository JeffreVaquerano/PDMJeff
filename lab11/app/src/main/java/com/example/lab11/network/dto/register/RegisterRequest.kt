package com.example.lab11.network.dto.register

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
)
