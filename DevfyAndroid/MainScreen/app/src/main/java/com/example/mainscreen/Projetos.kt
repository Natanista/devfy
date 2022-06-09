package com.example.mainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_api.model.UserLoginEmpresa
import com.example.android_api.rest.RestDevfy
import com.example.android_api.service.EmpresaService
import com.example.android_api.service.ProjetoService
import com.example.mainscreen.adapter.ProjetoAdapter
import com.example.mainscreen.model.Projeto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Projetos : AppCompatActivity() {

    private val retrofit = RestDevfy.getInstance()
    private lateinit var projetoAdapter: ProjetoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var projetoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projetos)
        projetoRecyclerView = findViewById(R.id.recycler_projetos)
        projetoRecyclerView.hasFixedSize()
        linearLayoutManager = LinearLayoutManager(this)
        projetoRecyclerView.layoutManager = linearLayoutManager

        getProjetosData()
    }

    fun voltar(view: View){
        val homescreen: Intent = Intent(
            baseContext,
            HomeScreen::class.java
        )
        startActivity(homescreen)
    }


    private fun getProjetosData() {

        val retrofitProjeto = retrofit.create(ProjetoService::class.java)

        val projetoResponseCall: Call<List<Projeto>> = retrofitProjeto.getProjetos()

        projetoResponseCall.enqueue(object : Callback<List<Projeto>> {
            override fun onResponse(call: Call<List<Projeto>>, response: Response<List<Projeto>>) {

                val responseBody = response.body()!!
                if(responseBody.isEmpty()){
                    Toast.makeText(baseContext, "Nenhum projeto disponivel", Toast.LENGTH_LONG).show()
                }

                else{
                    projetoAdapter = ProjetoAdapter(baseContext, responseBody)
                    projetoAdapter.notifyDataSetChanged()
                    projetoRecyclerView.adapter = projetoAdapter

                    projetoAdapter.onItemClick = {
                        val tela: Intent = Intent(
                            baseContext,
                            TelaEditarProjeto::class.java
                        )
                        tela.putExtra("id", it.id)

                        startActivity(tela)

                    }

                }



            }

            override fun onFailure(call: Call<List<Projeto>>, t: Throwable) {
                d("Projetos", "OnFailure: " + t.message)
            }

        })
    }
}