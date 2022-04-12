package com.example.android_api.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestDesenvolvedor {

    //mock com dados de desenvolvedores
    val baseUrl = "https://618324d791d76c00172d17c8.mockapi.io/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}