package com.example.mainscreen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.android_api.rest.RestDevfy
import com.example.android_api.service.ProjetoService
import com.example.mainscreen.model.Projeto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreen : AppCompatActivity() {
    private val retrofit = RestDevfy.getInstance()
    private lateinit var sharedPreferences: SharedPreferences
    private var projetosEmAndamento : Int = 0
    private var projetosAbertos : Int = 0
    private var projetosConcluido : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
        var nomeEmpresa = intent.getStringExtra(
            "nomeEmpresa"
        )
        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        nomeEmpresa =  sharedPreferences.getString("USER", "natanista")
        contagemProjetos();

        showWelcomeMessage(nomeEmpresa.toString())
    }

    fun contagemProjetos(){

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)
        val todosProjetosResponseCall: Call<List<Projeto>> = retrofitProjeto.getProjetos()

        todosProjetosResponseCall.enqueue(object : Callback<List<Projeto>> {
            override fun onResponse(call: Call<List<Projeto>>, response: Response<List<Projeto>>) {
                response.body()?.forEach{
                    if (it.status == "Andamento"){
                        projetosEmAndamento++
                    }
                    else if (it.status == "Aberto"){
                        projetosAbertos++
                    }
                    else if (it.status == "Concluido"){
                        projetosConcluido++
                    }
                }
            }

            override fun onFailure(call: Call<List<Projeto>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro de conexao" + t.message, Toast.LENGTH_LONG).show()
            }


        })
    }


    fun showWelcomeMessage(nomeEmpresa: String) {
        findViewById<TextView>(R.id.tv_welcome_message).text =
            getString(R.string.welcome_message, nomeEmpresa)
    }

    fun irAdicionarProjeto(view: View) {

        val telaAdicionarProjeto: Intent = Intent(
            baseContext,
            AddProjeto::class.java
        )
        startActivity(telaAdicionarProjeto)
    }

    fun irTelaVizualizarProjetos(view: View) {
        val telaVizualizarProjetos: Intent = Intent(
            baseContext,
            Projetos::class.java
        )
        startActivity(telaVizualizarProjetos)
    }

    fun irEfetuarPagamento(view: View) {
        val telaEfetuarPagamento: Intent = Intent(
            baseContext,
            EfetuarPagamento::class.java
        )
        startActivity(telaEfetuarPagamento)
    }


}