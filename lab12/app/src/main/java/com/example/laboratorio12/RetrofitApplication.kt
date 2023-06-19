package com.example.laboratorio12

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.media.session.MediaSession.Token
import com.example.laboratorio12.network.retrofit.RetrofitInstance
import com.example.laboratorio12.network.service.AuthService
import com.example.laboratorio12.repository.CredentialsRepository

class RetrofitApplication : Application() {

    private val pref: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    private fun getAPIService() = with(RetrofitInstance){
        setToken(getToken())
        getLoginService()
    }

    fun getToken(): String = pref.getString(USER_TOKEN, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    fun saveAuthToken(token: String){
        val editor = pref.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}