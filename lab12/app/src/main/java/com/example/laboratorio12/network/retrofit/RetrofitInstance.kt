package com.example.laboratorio12.network.retrofit

import android.media.session.MediaSession.Token
import com.example.laboratorio12.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://retrofit.up.railway.app/"

object RetrofitInstance {

    private var token = ""

    fun setToken(token: String){
        RetrofitInstance.token = token
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}