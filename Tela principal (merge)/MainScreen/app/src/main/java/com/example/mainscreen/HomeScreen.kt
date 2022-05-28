package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homescreen)
        val nomeEmpresa = intent.getStringExtra(
            "nomeEmpresa"
        )

        showWelcomeMessage(nomeEmpresa.toString())
    }

    fun showWelcomeMessage(nomeEmpresa: String){
        findViewById<TextView>(R.id.tv_welcome_message).text = getString(R.string.welcome_message, nomeEmpresa)
    }

    fun irAdicionarProjeto(view: View){

        val telaAdicionarProjeto: Intent = Intent(
            baseContext,
            AddProjeto::class.java
        )

        startActivity(telaAdicionarProjeto)
    }


}