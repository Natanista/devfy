package com.example.android_api.service

import com.example.android_api.model.Desenvolvedor
import com.example.mainscreen.model.TemplateProjeto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProjetoService {

    @POST("projetos")
    fun cadastrarProjeto(@Body templateProjeto: TemplateProjeto): Call<Void>

    @GET("projetos/{id}")
    fun getById(
        @Path("id") id: Long
    ): Call<List<TemplateProjeto>>
}