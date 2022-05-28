package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.android_api.model.UserLoginEmpresa
import com.example.android_api.rest.RestDevfy
import com.example.android_api.service.EmpresaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private val retrofit = RestDevfy.getInstance()
    private var nomeEmpresa: String = ""
    private var usuario: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
         usuario = intent.getStringExtra(
            "usuario"
        ).toString()
         nomeEmpresa = intent.getStringExtra(
            "nomeEmpresa"
        ).toString()

        definirUsuario()
    }

    private fun definirUsuario() {
        findViewById<EditText>(R.id.et_usuario).setText(usuario)
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
                    findViewById<TextView>(R.id.tv_login_invalido).visibility = View.GONE


                    val home: Intent = Intent(
                        baseContext,
                        HomeScreen::class.java
                    )
                    home.putExtra("nomeEmpresa", nomeEmpresa)

                    startActivity(home)
                }else {
                    findViewById<TextView>(R.id.tv_login_invalido).visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Toast.makeText(baseContext,  "Erro de conexao" + t.message, Toast.LENGTH_LONG).show()
            }

        })




    }


}