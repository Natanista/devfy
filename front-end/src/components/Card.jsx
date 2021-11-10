import React from "react";
import '../html/css/dashboard.css'

function Card(props) {
  return (
    <div class="div_card_projetos">
      <div class="div_card_conteudo">
          <p>
            <strong>Projeto: </strong>{props.projeto}
          </p>
          
          <p>
            <strong>Empresa: </strong>{props.empresa}
          </p>
          
          <p>
            <strong>Linguagem: </strong>{props.linguagem}
          </p>
        
          <p>
            <strong>Tempo est.: </strong>{props.tempoEst}
          </p>

    <div class="div_card_button">
      <div class="div_esq"><a href="#">Mais informações</a></div>
      <div class="div_dir"><b>100 - 200 R$</b></div>
    </div>

    </div>
    </div>
    );
}

export default Card;