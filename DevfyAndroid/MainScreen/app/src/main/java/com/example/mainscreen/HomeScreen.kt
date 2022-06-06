package com.example.mainscreen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeScreen : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
        var nomeEmpresa = intent.getStringExtra(
            "nomeEmpresa"
        )
        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        nomeEmpresa =  sharedPreferences.getString("USER", "natanista")

        showWelcomeMessage(nomeEmpresa.toString())
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