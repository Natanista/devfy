package com.example.android_api.service

import com.example.android_api.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EmpresaService {

    @POST("empresas/login")
    fun logar(@Body UserLoginEmpresa: UserLoginEmpresa): Call<Boolean>

    @POST("empresas")
    fun cadastrarEmpresa(@Body userCadastroEmpresa: UserCadastroEmpresa): Call<Void>


}