package com.example.android_api.service

import com.example.android_api.model.Desenvolvedor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DesenvolvedorService {

    @GET("/desenvolvedor")
    fun list(): Call<List<Desenvolvedor>>

    @GET("/desenvolvedor/{id}")
    fun getById(
        @Path("id") id: Long
    ): Call<List<Desenvolvedor>>
}