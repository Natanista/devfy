package com.example.android_api.service

import com.example.android_api.model.LoginResponse
import com.example.android_api.model.UserEmpresa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EmpresaService {

    @POST("/LoginResponse")
    fun logar(@Body userEmpresa: UserEmpresa): Call<LoginResponse>

    @POST("/Empresas")
    fun registrar(@Body registerEmpresa: RegisterEmpresa): Call<RegisterEmpresa>


}