package com.example.android_api.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestProjetos {

    val baseUrl = "http://localhost:8080/devfy"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}