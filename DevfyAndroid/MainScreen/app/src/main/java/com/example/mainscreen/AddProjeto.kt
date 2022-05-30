package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.android_api.rest.RestDevfy
import com.example.android_api.service.ProjetoService
import com.example.mainscreen.databinding.EfetuarPagamentoBinding
import com.example.mainscreen.model.TemplateProjeto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProjeto : AppCompatActivity() {
    private val retrofit = RestDevfy.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_projeto)
    }

    fun adicionarProjeto(view: View) {

        val titulo: String = findViewById<EditText>(R.id.etTitulo).text.toString()
        val linguagem: String = findViewById<EditText>(R.id.etLinguagem).text.toString()
        val descricao: String = findViewById<EditText>(R.id.etDescricao).text.toString()
        val valor: String = findViewById<EditText>(R.id.etValor).text.toString()


        var projeto = TemplateProjeto(titulo, linguagem, descricao, valor)

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)

        val cadastroResponseCall: Call<Void> = retrofitProjeto.cadastrarProjeto(projeto)

        cadastroResponseCall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 201) {
                    val projetosTela: Intent = Intent(
                        baseContext,
                        Projetos::class.java
                    )
                    startActivity(projetosTela)
                } else {
                    Toast.makeText(baseContext, "Erro ao cadastrar projetos!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro no servidor!", Toast.LENGTH_LONG).show()
            }

        })
    }

}