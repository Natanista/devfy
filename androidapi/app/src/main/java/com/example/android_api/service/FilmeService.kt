package com.example.android_api.service

import com.example.android_api.model.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmeService {

    @GET("/filme")
    fun list(): Call<List<Filme>>

    @GET("/filme/{id}")
    fun getById(
        @Path("id") id: Long
    ): Call<List<Filme>>
}