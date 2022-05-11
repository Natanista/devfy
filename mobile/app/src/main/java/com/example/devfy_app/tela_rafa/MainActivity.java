package com.example.myapplication

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View

class MainActivity :AppCompatActivity(){
        override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

        fun projetosAberto(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun projetosAndamento(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun projetosConcluido(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun panel1(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun panel2(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun panel3(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun panel4(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun irPerfil(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }

        fun irDevs(view:View){
        val tela2:Intent=Intent(
        baseContext,
        Tela2::class.java
        )
        tela2.putExtra("nome_usuario","Caio")
        tela2.putExtra("idade_usuario",26)
        startActivity(tela2)
        }
        }