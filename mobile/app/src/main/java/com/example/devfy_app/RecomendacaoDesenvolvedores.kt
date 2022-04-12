package com.example.devfy_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.android_api.model.Desenvolvedor
import com.example.android_api.rest.RestDesenvolvedor
import com.example.android_api.service.DesenvolvedorService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecomendacaoDesenvolvedores : AppCompatActivity() {

    private lateinit var layoutContainer: LinearLayout
    private val retrofit = RestDesenvolvedor.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendacao_desenvolvedores)
        layoutContainer = findViewById(R.id.ll_devs_recomendados)
        buscarTodos()
    }


    fun buscarTodos() {
        val devsRequest = retrofit.create(DesenvolvedorService::class.java)
        devsRequest.list().enqueue(
            object : Callback<List<Desenvolvedor>> {
                override fun onResponse(
                    call: Call<List<Desenvolvedor>>,
                    response: Response<List<Desenvolvedor>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.forEach { dev ->
                            val tvDev = TextView(baseContext)
                            tvDev.setText(
                                "\n\nNome:" + dev.nome +
                                        "\nLinguagem:" + dev.linguagem +
                                        "\npreco:" + dev.precoHora +
                                        "\nprojetos feitos:" + dev.projetosAtuando
                            )
                            val button = Button(baseContext)
                            button.setText("contratar")
                            layoutContainer.addView(tvDev)
                            layoutContainer.addView(button)
                        }
                    } else {
                        Toast.makeText(baseContext, "Verifique o log da API", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<Desenvolvedor>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

            }
        )
    }

}