import React from "react";

import Menu from "../components/Menu";
import BotaoVerde from "../components/Botao2";
import logoGrande from '../html/img/LogoGrande.png';


const Login = () => (
   <div>
    <Menu />
        <div class="content-tudo">
        <div class="cont-one">
            <img src={logoGrande} alt="" />
        </div>
        <div class="cont-two-login">
            <h2>Login</h2>
            <div class="cont-info">
                <label for="">Usuário</label><br />
                <input type="text" name="" id="" class="input_info" placeholder="Digite usuário ou e-mail" />
                <br />
                <label for="">Senha</label><br />
                <input type="password" name="" id="" class="input_info" placeholder="*****" />
                <br />
                <BotaoVerde />
            </div>
        </div>
    </div>
    </div>
);
  
  export default Login;