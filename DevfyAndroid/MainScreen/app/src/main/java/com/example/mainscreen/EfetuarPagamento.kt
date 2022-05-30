package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EfetuarPagamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.efetuar_pagamento)
    }

    fun irTelaConfirmacaoPagamento(view: View) {
        val telaConfirmacaoPagamento: Intent = Intent(
            baseContext,
            ConfirmacaoPagamento::class.java
        )
        startActivity(telaConfirmacaoPagamento)
    }
}