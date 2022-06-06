package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.android_api.rest.RestDevfy
import com.example.android_api.service.ProjetoService
import com.example.mainscreen.model.Projeto
import com.example.mainscreen.model.TemplateProjeto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class TelaEditarProjeto : AppCompatActivity() {
    private val retrofit = RestDevfy.getInstance()
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_editar_projeto)
         id = intent.getIntExtra(
            "id", 1
        )
        getProjetoById(id)
    }

    fun editarProjeto(view: View){
        val titulo: String = findViewById<EditText>(R.id.etTitulo).text.toString()
        val linguagem: String = findViewById<EditText>(R.id.etLinguagem).text.toString()
        val descricao: String = findViewById<EditText>(R.id.etDescricao).text.toString()
        val valor: String = findViewById<EditText>(R.id.etValor).text.toString()


        var projeto = TemplateProjeto(titulo, linguagem, descricao, valor)

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)

        val updateResponseCall: Call<Void> = retrofitProjeto.updateProject(id ,projeto)

        updateResponseCall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200) {
                    val projetosTela: Intent = Intent(
                        baseContext,
                        Projetos::class.java
                    )
                    startActivity(projetosTela)
                } else {
                    Toast.makeText(baseContext, "Erro ao atualizar projetos!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro no servidor!", Toast.LENGTH_LONG).show()
            }

        })

    }

    fun excluirProjeto(view: View){

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)

        val deleteResponseCall: Call<Void> = retrofitProjeto.deleteProject(id)

        deleteResponseCall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200) {
                    val projetosTela: Intent = Intent(
                        baseContext,
                        Projetos::class.java
                    )
                    startActivity(projetosTela)
                } else {
                    Toast.makeText(baseContext, "Erro ao deletar projetos!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro no servidor!", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun getProjetoById(id: Int) {

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)

        val projetoResponseCall: Call<Projeto> = retrofitProjeto.getProjetosById(id)

        projetoResponseCall.enqueue(object : Callback<Projeto> {
            override fun onResponse(call: Call<Projeto>, response: Response<Projeto>) {
                findViewById<EditText>(R.id.etTitulo).setText(response.body()?.titulo)
                findViewById<EditText>(R.id.etDescricao).setText(response.body()?.descricao)
                findViewById<EditText>(R.id.etLinguagem).setText(response.body()?.linguagem)
                findViewById<EditText>(R.id.etValor).setText(response.body()?.valor.toString())
            }

            override fun onFailure(call: Call<Projeto>, t: Throwable) {
                Toast.makeText(baseContext, "Erro de conexao" + t.message, Toast.LENGTH_LONG).show()

            }


        })
    }



}