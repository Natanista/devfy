import React, { useEffect, useState} from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
import icon_dow from '../html/img/import.png'
import Card from "../components/Card";
import '../html/css/dashboardEmpresa.css';
import api from "../api";
import { Link } from "react-router-dom";

function Cards() {


    const [numero, setNumero] = useState("");
    const [saldo, setSaldo] = useState("");
    const [valorDebito, setValorDebito] = useState("");
    const [valorDeposito, setValorDeposito] = useState("");


    useEffect(() => {
      async function getConta() {
          const resposta = await api
          .get("/conta-bancaria/1")
          .then((resposta) => {
              console.log("Achei esse id: ", resposta)
              setNumero(resposta.data.numero);
              setSaldo(resposta.data.saldo);
          })
          .catch((erro) => {
              console.log("Erro ao buscar projeto pelo id")
          })
      }
      getConta();
    }, [])

    function depositar(e){
        e.preventDefault();
        api.patch(`/conta-bancaria/depositar/1`,{
            valor: valorDeposito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function debitar(e){
        e.preventDefault();
        api.patch(`/conta-bancaria/debitar/1`,{
            valor: valorDebito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function debitarAgendado(e){
        e.preventDefault();
        api.post(`/conta-bancaria/debito-agendado/1`,{
            valor: valorDebito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function depositarAgendado(e){
        e.preventDefault();
        api.post(`/conta-bancaria/deposito-agendado/1`,{
            valor: valorDeposito
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function executarOperacao(e){
        e.preventDefault();
        api.post(`/conta-bancaria/executar-operacao`,{
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    
    }

    function desfazer(e) {
        e.preventDefault();
        api.post(`/conta-bancaria/desfazer-operacao`,{
        }).then((resposta) => {
            location.reload();
         // history.push("/dashboard-empresa")
        }).catch((erro) => {
          console.log("Erro ao cadastrar música!")
        });
    }

    const [cards, setCards] = useState([]); 

    useEffect(() => {
        async function buscarCards(){
          const resposta = await api.get(`/projetos`)
          setCards(resposta.data)
          console.log("olha o que veio da api!!!",resposta.data)
        }
        buscarCards()
      },[]);
    

        return (
            <div>
                <div>
                    <MenuLogado/>
                </div>

                <div className="div_fundo">
                    <div className="div_esquerda">
                        <div className="div_status_projeto">
                            <div className="conteudo_financeiro">
                                <h3>Status dos projetos:</h3>
                                <br/>
                                <p><b>Projetos em aberto:</b> 3</p>
                                <p><b>Projetos em andamentos:</b>5</p>
                                <p><b>Projetos finalizados:</b>90</p>
                                <p><b>Contratos em andamento:</b>3</p>

                                <br />
                                <h3>Financeiro</h3>
                                <br />
                                <p><b>Conta: </b> {numero}</p>
                                <p><b>Saldo:</b> R${saldo}</p>
                                <label htmlFor="saldoDeposito">Depósito: </label><br />
                                <input onChange={e => setValorDeposito(e.target.value)} type="text" name="saldoDeposito" id="saldoDeposito" />
                                <br   />
                                <button onClick={depositar}>Deposito imediato</button>
                                <br />
                                <button onClick={depositarAgendado}>Agendar deposito</button>
                                <br />

                                <label htmlFor="saldoSaque">Saque:     </label><br />
                                <input onChange={e => setValorDebito(e.target.value)}  type="text" name="saldoSaque" id="saldoSaque" />
                                <br />
                                <button onClick={debitar}>Saque imeadiato</button>
                                <br />

                                <button onClick={debitarAgendado}>Agendar Saque</button>
                                <br />

                                
                                <button onClick={executarOperacao}> <b> Atualiza Financeiro</b> </button>
                                <button onClick={desfazer} ><b>Desfazer</b></button>
                              


                            </div>
                        </div>
                        <div className="div_status_cards">
                            <div className="conteudo_status">
                                <h3>Status dos cards</h3>
                                <br />
                                <ul>
                                    <li className="li_1">Aberto</li>
                                    <li className="li_1">Finalizado</li>
                                    <li className="li_1">Andamento</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div className="div_direita">
                        <div className="div_icons">

                            <img className="icone_dow_img" src={icon_dow} alt="icone de Download" />
                            <Link to="/cadastrar-projeto">
                            <button className="btn_cadastrar_projeto">Cadastrar projeto</button>
                            </Link>

                            <select id="card" className="dropdown_status">
                                <option value="#">Selecione status do projeto</option>
                                <option value="aberto">Aberto</option>
                                <option value="finalizado">Finalizado</option>
                                <option value="andamento">Andamento</option>
                            </select>

                        </div>
                        <div className="div_cards">
                            { 
                                cards.map((card) => (
                                    <Card
                                        key={card.id}
                                        id={card.id}
                                        titulo={card.titulo}
                                        categoria={card.categoria}
                                        linguagem={card.linguagem}
                                        publicadoEm={card.publicadoEm}
                                        descricao={card.descricao}
                                        valor={card.valor}
                                    />
                                ))
                            }
                        </div>

                    </div>

                    <br />
                </div>

                <div>
                    <Footer />
                </div>
                </div>
        )
    }
export default Cards;
