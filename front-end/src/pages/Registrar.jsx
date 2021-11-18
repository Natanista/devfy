import React, { useState } from "react";
import api from "../api";
import Menu from "../components/Menu";
import { useHistory } from 'react-router';
import logoGrande from '../html/img/LogoGrande.png';

function Registrar() {

  const [nomeDigitado, setNomeDigitado] = useState("");
  const [emailDigitado, setemailDigitado] = useState("");
  const [telefoneDigitado, settelefoneDigitado] = useState("");
  const [paisDigitado, setpaisDigitado] = useState("");
  const [cepDigitado, setcepDigitado] = useState("");
  const [representanteDigitado, setrepresentanteDigitado] = useState("");
  const [telefoneRepresentanteDigitado, settelefoneRepresentanteDigitado] = useState("");
  const [usuarioDigitado, setusuarioDigitado] = useState("");
  const [senhaDigitada, setsenhaDigitada] = useState("");
  const [cnpjDigitado, setcnpjDigitado] = useState("");

  const history = useHistory();


  function cadastrar(e) {
    e.preventDefault();

    api.post(`https://localhost:8080/devfy/empresas`, {
      nome: nomeDigitado,
      email: emailDigitado,
      telefone: telefoneDigitado,
      pais: paisDigitado,
      cep: cepDigitado,
      representante: representanteDigitado,
      telefoneRepresentante: telefoneRepresentanteDigitado,
      usuario: usuarioDigitado,
      senha: senhaDigitada,
      cnpj: cnpjDigitado
    }).then((resposta) => {
      history.push("/login")
    }).catch((erro) => {
      alert("Erro ao cadastrar a empresa!")
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
          <h2>Cadastrar</h2>

          <form onSubmit={cadastrar}>
            <label>
              Nome: <br />
              <input type="text" onChange={e => setNomeDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Email: <br />
              <input type="text" onChange={e => setemailDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Telefone: <br />
              <input type="text" onChange={e => settelefoneDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Pais: <br />
              <input type="text" onChange={e => setpaisDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              CEP: <br />
              <input type="text" onChange={e => setcepDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              CNPJ: <br />
              <input type="text" onChange={e => setcnpjDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Representante: <br />
              <input type="text" onChange={e => setrepresentanteDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Telefone Representante: <br />
              <input type="text" onChange={e => settelefoneRepresentanteDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Usuário: <br />
              <input type="text" onChange={e => setusuarioDigitado(e.target.value)} />
            </label>
            <br />
            <label>
              Senha: <br />
              <input type="text" onChange={e => setsenhaDigitada(e.target.value)} />
            </label>
            <br />

            <button type="submit">Enviar</button>

          </form>
        </div>
      </div>
    </div>
  );
}

export default Registrar;