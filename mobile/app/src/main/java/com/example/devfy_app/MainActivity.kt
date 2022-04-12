package com.example.devfy_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irTela2(view: View) {
        val telaTeste: Intent = Intent(
            baseContext,
            //COLOQUE AQUI A TELA PRA ONDE QUER IR
            RecomendacaoDesenvolvedores::class.java
        )
//        tela2.putExtra("nome_usuario", "Caio")
//        tela2.putExtra("idade_usuario", 26)
        startActivity(telaTeste)
    }
}