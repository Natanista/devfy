import React from "react";
import '../html/css/dashboard.css'

function Card(props) {
  return (
    <div class="div_card_projetos">
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
      asdasd
    </div>

    </div>
    );
}

export default Card;