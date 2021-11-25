import React, { useEffect, useState} from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
import icon_dow from '../html/img/baixar.png'
import Card from "../components/Card";
import '../html/css/dashboardEmpresa.css';
import api from "../api";

function Cards() {
    const [cards, setCards] = useState([]); 

    useEffect(() => {
        async function buscarCards() {
            const resposta = await api.get("/projetos")
            setCards(resposta.data)
            console.log("olha o que veio da api!!!", resposta.data)
        }
        buscarCards()
    }, []);

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
                            <button className="btn_cadastrar_projeto">Cadastrar projeto</button>
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
                                        empresa={card.empresa}
                                        linguagem={card.linguagem}
                                        tempoEstimado={card.tempoEst}
                                        descricao={card.descricao}
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
