package com.example.android_api.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestEmpresa {

    //mock com dados de desenvolvedores
    val baseUrl = "http://devfy.sytes.net:8080/devfy/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}