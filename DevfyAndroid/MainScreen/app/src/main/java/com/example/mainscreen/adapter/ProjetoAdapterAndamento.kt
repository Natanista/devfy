package com.example.mainscreen.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainscreen.Projetos
import com.example.mainscreen.R
import com.example.mainscreen.model.Projeto

class ProjetoAdapterAndamento(val context: Context, val projetoList: List<Projeto>): RecyclerView.Adapter<ProjetoAdapterAndamento.ProjetoHolder>() {

    var onItemClick: ((Projeto) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjetoHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_projeto_aberto,
        parent, false)
        return ProjetoHolder(itemView)
    }



    override fun onBindViewHolder(holder: ProjetoHolder, position: Int) {
        var projetosEmAndamento = listOf<Projeto>()
        projetoList.forEach{
            if (it.status == "Andamento"){
                projetosEmAndamento.toMutableList().add(it)
            }
        }
        val currentItem = projetosEmAndamento[position]
        holder.nomeProjeto.text = currentItem.titulo
        holder.descricaoProjeto.text = currentItem.descricao
        holder.linguagemProjeto.text = currentItem.linguagem
        holder.precoProjeto.text = currentItem.valor.toString()

        holder.itemView.setOnClickListener {
            val telaEditarProjetoEmAndamento: Intent = Intent(this.context, Projetos::class.java)
            telaEditarProjetoEmAndamento.putExtra("id",holder.itemId)
            context.startActivity(telaEditarProjetoEmAndamento)

        }

    }

    override fun getItemCount(): Int {
        return projetoList.size
    }

    class ProjetoHolder(projetoView: View): RecyclerView.ViewHolder(projetoView){

        val nomeProjeto: TextView = itemView.findViewById(R.id.tv_project_name)
        val linguagemProjeto: TextView = itemView.findViewById(R.id.tv_projeto_linguagem)
        val precoProjeto: TextView = itemView.findViewById(R.id.tv_projeto_preco)
        val descricaoProjeto: TextView = itemView.findViewById(R.id.tv_projeto_descricao)



    }
}