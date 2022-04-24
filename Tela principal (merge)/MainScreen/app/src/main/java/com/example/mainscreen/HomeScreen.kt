package com.example.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val nomeEmpresa = intent.getStringExtra(
            "nomeEmpresa"
        )

        showWelcomeMessage(nomeEmpresa.toString())
    }

    fun showWelcomeMessage(nomeEmpresa: String){
        findViewById<TextView>(R.id.tv_login_sucesso).text = getString(R.string.usuario_autenticado, nomeEmpresa)
    }

    fun logoff(view : View){

    }
}