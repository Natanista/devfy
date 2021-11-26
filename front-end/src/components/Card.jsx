import React from "react";
import icon_dow from '../html/img/baixar.png'
import '../html/css/dashboardEmpresa.css'
import api from "../api"
import { Link } from 'react-router-dom';

function Card(props) {

  function deletarMusica(){
    api.delete(`/projetos/${props.id}`)
    .then((resposta)=>{
      window.location.reload();
    })
    .catch((erro) => {
      console.log("ERRO AO DELETAR!")
    })
  }

  function donwload(){
    api.get(`projetos/export-csv/${props.id}`)
    .then((resposta)=>{
    })
    .catch((erro) => {
      console.log("erro ao efetuar donwload")
    })
  }






  return (
    <div class="div_card_projetos">
      <div class="div_card_conteudo">
      <div class="icone_dow">
      <img onClick={donwload} target="_blank" class="icone_dow_img" src={icon_dow} alt="icone de Download" donwload/>
       </div>
          <p>
            <strong>Título: </strong>{props.titulo}
          </p>
          
          <p>
            <strong>Categoria: </strong>{props.categoria}
          </p>
          
          <p>
            <strong>Linguagem: </strong>{props.linguagem}
          </p>
      
          <p>
            <b>Publicado em: {props.publicadoEm}</b>
          </p>
          <p>
            <strong>Descrição: </strong>
          </p>

          <p class="card_descricao">
          {props.descricao}
          </p>


      <Link to="/dashboard-empresa">
      <button class="btn_vermelho" onClick={deletarMusica}>Excluir</button>
      </Link>

      <Link to={`/atualizar-projeto/${props.id}`}>
      <button  class="btn_verde">Editar</button>
      </Link>
      
      <p class="p_valor"><b> R${props.valor}</b></p>
    </div>
   
    
    </div>
    );
}

export default Card;