package com.example.android_api.service

import com.example.android_api.model.Desenvolvedor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DesenvolvedorService {

    @GET("desenvolvedores")
    fun list(): Call<List<Desenvolvedor>>

    @GET("desenvolvedores/{id}")
    fun getById(
        @Path("id") id: Long
    ): Call<List<Desenvolvedor>>
}