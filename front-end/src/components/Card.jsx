import React from "react";
import icon_dow from '../html/img/baixar.png'
import '../html/css/dashboardEmpresa.css'
import api from "../api"

function Card(props) {

  function deletarMusica(){
    api.delete(`/${props.id}`)
    .then((resposta)=>{
      window.location.reload();
      console.log("DELETOU!!!")
    })
    .catch((erro) => {
      console.log("ERRO AO DELETAR!")
    })
  }

  return (
    <div class="div_card_projetos">
      <div class="div_card_conteudo">
      <div class="icone_dow">
      <img class="icone_dow_img" src={icon_dow} alt="icone de Download" />
       </div>
          <p>
            <strong>Título: </strong>{props.titulo}
          </p>
          
          <p>
            <strong>Empresa: </strong>{props.empresa}
          </p>
          
          <p>
            <strong>Linguagem: </strong>{props.linguagem}
          </p>
        
          <p>
            <strong>Tempo estimado: </strong>{props.tempoEst}
          </p>
          <p>
            <b>Publicado em:</b>
          </p>
          <p>
            <strong>Descrição: </strong>
          </p>

          <p class="card_descricao">
          {props.descricao}
          </p>

      <button class="btn_verde">Editar</button>

      <button class="btn_vermelho" onClick={deletarMusica}>Excluir</button>

      <p class="p_valor"><b> R$ 150 - 150</b></p>
    </div>
   
    
    </div>
    );
}

export default Card;