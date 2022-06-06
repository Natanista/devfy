package com.example.mainscreen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun irTelaRegistrar(view:View){
        val registrar: Intent = Intent(
            baseContext,
            Register::class.java
        )
        startActivity(registrar)
    }

    fun irTelaLogin(view:View){
        val login: Intent = Intent(
            baseContext,
            Login::class.java
        )
        startActivity(login)
    }

    fun embreve(view:View){
        Toast.makeText(this,"Conteudo não disponivel!",Toast.LENGTH_LONG).show()
    }
}