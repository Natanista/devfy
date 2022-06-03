package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ConfirmacaoPagamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmacao_pagamento)
    }

    fun irTelaVizualizarProjetos(view: View) {
        val telaInicial: Intent = Intent(
            baseContext,
            HomeScreen::class.java
        )
        startActivity(telaInicial)
    }
}