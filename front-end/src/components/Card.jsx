import React from "react";
import '../html/css/dashboardEmpresa.css'

function Card(props) {
  return (
    <div class="div_card_projetos">
      <div class="div_card_conteudo">
          <p>
            <strong>Título: </strong>{props.projeto}
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
            <strong>Descrição: </strong>
          </p>

          <span>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
          {props.descricao}
          </span>

    </div>
    </div>
    );
}

export default Card;