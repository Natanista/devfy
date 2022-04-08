package com.example.android_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.android_api.model.Filme
import com.example.android_api.rest.Rest
import com.example.android_api.service.FilmeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var etFilme: EditText
    private lateinit var layoutContainer: LinearLayout
    private val retrofit = Rest.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etFilme = findViewById(R.id.et_filme)
        layoutContainer = findViewById(
            R.id.layout_container
        )
    }

    fun buscarPorId(view: View) {
        val id = etFilme.text.toString().toLong()
        val filmeRequest = retrofit.create(
            FilmeService::class.java
        )
        filmeRequest.getById(id).enqueue(
            object : Callback<Filme> {
                override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                    if (response.isSuccessful) {
                        val filme = response.body()?.title
                        val tvFilme =TextView(baseContext)
                        tvFilme.text = filme
                        layoutContainer.removeAllViews()
                        layoutContainer.addView(tvFilme)

                    } else {
                        Toast.makeText(
                            baseContext,
                            "Verifique os logs",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

                override fun onFailure(call: Call<Filme>, t: Throwable) {
                    Toast.makeText(
                        baseContext,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        )
    }

    fun buscarTodos(view: View) {
        val filmesRequest = retrofit.create(FilmeService::class.java)
        filmesRequest.list().enqueue(
            object : Callback<List<Filme>> {
                override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                    if (response.isSuccessful) {
                        response.body()?.forEach { filme ->
                            val tvFilme = TextView(baseContext)
                            tvFilme.text = filme.title
                            layoutContainer.addView(tvFilme)
                        }
                    } else {
                        Toast.makeText(baseContext, "Verifique o log da API", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

            }
        )
    }
}