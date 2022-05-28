package com.example.android_api.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestDevfy {

    //mock com dados de desenvolvedores
    val baseUrl = "http://3.209.29.33/devfy/"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}