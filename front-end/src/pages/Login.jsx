import React, { useState } from "react";

import Menu from "../components/Menu";
import logoGrande from '../html/img/LogoGrande.png';
import api from "../api";


function Login() {

    const [usuarioDigitado, setUsuarioDigitado] = useState("");
    const [senhaDigitado, setSenhaDigitado] = useState("");

    function logar(e) {
        e.preventDefault();

        api.post(`http://localhost:8080/devfy/empresas/login`, {
            usuario: usuarioDigitado,
            senha: senhaDigitado,
        }).then((resposta) => {
            if (!resposta.data) {
                alert("senha Incorreta! //TODO criar os erros de senha")
            } else {
                alert("Usuario Logado!");
                window.location = "/dashboard"
            }
            console.log(resposta);
        }).catch((erro) => {
            console.log("Erro ao consultar login!")
        });

    }


    return (
        <div>
            <Menu />
            <div class="content-tudo">
                <div class="cont-one">
                    <img src={logoGrande} alt="" />
                </div>
                <div class="cont-two-login">
                    <h2>Login</h2>
                    <form onSubmit={logar} class="cont-info">
                        <label for="">Usuário</label><br />
                        <input onChange={e => setUsuarioDigitado(e.target.value)} type="text" name="" id="" class="input_info" placeholder="Digite usuário ou e-mail" />
                        <br />
                        <label htmlFor="">Senha</label><br />
                        <input onChange={e => setSenhaDigitado(e.target.value)} type="text" name="" id="" class="input_info" placeholder="*****" />
                        <br />
                        <button type="submit">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    );

}

export default Login;