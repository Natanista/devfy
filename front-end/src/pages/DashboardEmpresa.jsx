import React from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
import icon_dow from '../html/img/baixar.png'
import Card from "../components/Card";
import '../html/css/dashboardEmpresa.css';



function DashboardEmpresa(){
    return(
<div>        
    <div>
        <MenuLogado/>
    </div>
        
    <div class="div_fundo">
        <div class="div_esquerda">
            <div class="div_status_projeto">
            <div class="conteudo_financeiro">
            <h3>Status dos projetos:</h3>
            <br />
       <p><b>Projetos em aberto:</b> 3</p>
         <p><b>Projetos em andamentos:</b>5</p>
       <p><b>Projetos finalizados:</b>90</p>
       <br />
       <h3>Financeiro</h3>
       <br />
       <p><b>Dísponivel par resgate:</b> R$ 300.00</p>
       <p><b>Contratos em andamento:</b>3</p>
       <br />
       <button> <b> Atualiza Financeiro</b> </button>
     </div>
            </div>

            <div class="div_status_cards">
                <div className="conteudo_status">
                    <h3>Status dos cards</h3>
                    <br />
                    <ul>
                    <li class="li_1">Aberto</li>
                    <li class="li_1">Finalizado</li>
                    <li class="li_1">Andamento</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="div_direita">
            <div class="div_icons">

                <img class="icone_dow_img" src={icon_dow} alt="icone de Download" />
                <p>Importar projeto</p>
                <button>Cadastrar projeto</button>
                <h2>Projetos</h2>
                <select id="card" class="card">
                    <option value="#">Selecione status do projeto</option>
                    <option value="aberto">Aberto</option>
                    <option value="finalizado">Finalizado</option>
                    <option value="andamento">Andamento</option>
                </select>

            </div>    
            <div class="div_cards">
                <Card/> 
            </div>
            
        </div>

    <br />
    </div>
    
    <div>
    <Footer/>
    </div>
</div>
)
}

export default DashboardEmpresa;