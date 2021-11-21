import React from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
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

            </div>

            <div class="div_status_cards">
                
            </div>
        </div>

        <div class="div_direita">
            <div class="div_icons">
                <h4>Projetos</h4>
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