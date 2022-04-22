package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.android_api.model.UserCadastroEmpresa
import com.example.android_api.rest.RestEmpresa
import com.example.android_api.service.EmpresaService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    private val retrofit = RestEmpresa.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }


    fun cadastrar(view: View) {

        val senhaDigitada: String = findViewById<EditText>(R.id.et_senha).text.toString()
        val usuarioDigitado: String = findViewById<EditText>(R.id.et_email).text.toString()
        val representanteDigitado: String = findViewById<EditText>(R.id.et_representante).text.toString()
        val nomeDigitado: String = findViewById<EditText>(R.id.et_nome).text.toString()
        val cnpjDigitado: String = findViewById<EditText>(R.id.et_cnpj).text.toString()
        var userCadastroEmpresa = UserCadastroEmpresa(representanteDigitado, usuarioDigitado, senhaDigitada, nomeDigitado, cnpjDigitado)

        val retrofirEmpresa = retrofit.create(EmpresaService::class.java)

        val cadastroResponseCall: Call<Void> =  retrofirEmpresa.cadastrarEmpresa(userCadastroEmpresa)

        cadastroResponseCall.enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 201){
                    //TODO: implementar logica de cadastro sucesso
                    Toast.makeText(baseContext,  "Empresa cadastrada com sucesso!" + response.body().toString(), Toast.LENGTH_LONG).show()
                }else {
                    //TODO: implementar logica de cadastro false
                    Toast.makeText(baseContext,  "A empresa nao foi cadastrada" + response.body().toString(), Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext,  "Erro no servidor!", Toast.LENGTH_LONG).show()
            }

        })
    }


    fun voltar(view:View){
        val tela1:Intent = Intent(this,MainActivity::class.java)
        startActivity(tela1)
    }
}