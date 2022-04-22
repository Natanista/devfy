package com.example.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.android_api.model.UserLoginEmpresa
import com.example.android_api.rest.RestEmpresa
import com.example.android_api.service.EmpresaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private val retrofit = RestEmpresa.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun logar(view: View) {

        val usuarioDigitado: String = findViewById<EditText>(R.id.et_usuario).text.toString()
        val senhaDigitada: String = findViewById<EditText>(R.id.et_senha).text.toString()
        var usuarioEmpresa = UserLoginEmpresa(usuarioDigitado, senhaDigitada)

        val retrofitEmpresa = retrofit.create(EmpresaService::class.java)

        val loginResponseCall: Call<Boolean> = retrofitEmpresa.logar(usuarioEmpresa)

        loginResponseCall.enqueue(object: Callback<Boolean>{
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if(response.body() == true){
                    //TODO: implementar logica de login sucesso
                Toast.makeText(baseContext,  "LOGIN EFETUADO COM SUCESSO:" + response.body().toString(), Toast.LENGTH_LONG).show()
                }else {
                    //TODO: implementar logica de login false
                    Toast.makeText(baseContext,  "USUARIO OU SENHA INCORRETOS!" + response.body().toString(), Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Toast.makeText(baseContext,  "Erro de conexao" + t.message, Toast.LENGTH_LONG).show()
            }

        })




    }


}