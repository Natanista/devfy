package com.example.android_api.service

import com.example.android_api.model.Desenvolvedor
import com.example.mainscreen.model.Projeto
import com.example.mainscreen.model.TemplateProjeto
import retrofit2.Call
import retrofit2.http.*

interface ProjetoService {

    @POST("projetos")
    fun cadastrarProjeto(@Body templateProjeto: TemplateProjeto): Call<Void>

    @GET("projetos")
    fun getProjetos(
    ): Call<List<Projeto>>

    @GET("projetos/{id}")
    fun getProjetosById(
        @Path("id") id: Int
    ): Call<Projeto>

    @DELETE("projetos/{id}")
    fun deleteProject(
        @Path("id") id: Int
    ): Call<Void>

    @PUT("projetos/{id}")
    fun updateProject(
        @Path("id") id: Int,
        @Body projeto: TemplateProjeto
    ): Call<Void>

}