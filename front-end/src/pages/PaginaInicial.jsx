import React from "react";
import BotaoLaranja from "../components/Botao";
import BotaoVerde from "../components/Botao2";
import Menu from "../components/Menu";
import Footer from "../components/Footer";

import funciona from '../html/img/1.svg';
import funciona2 from '../html/img/2.svg';
import funciona3 from '../html/img/3.svg';
import beneficio from '../html/img/dollar.svg';
import beneficio2 from '../html/img/emoji_happy.svg';
import rede from '../html/img/facebook.png';
import rede2 from '../html/img/instagram.png';
import rede3 from '../html/img/linkedin.png';
import logo from '../html/img/LOGO.png';
import mulherHistoria from '../html/img/mulher.svg';
import bannerPessoas from '../html/img/pessoas.png';
import beneficio3 from '../html/img/seguro.svg';
import rede4 from '../html/img/telephone.png';

function PaginaInicial() {
  return (
    <div>
      <Menu />
      <div class="banner">
        <div class="container">
          <div class="cont">
            <div class="banner_left">
              <h1> Encontre Projetos e Freelancers </h1>
              <p>Entre na plataforma ideal para quem procura trabalhos freelance ou procura freelancers para seus
                        trabalhos e projetos!</p>
              <div class="text_banner">
                <BotaoLaranja />
                <p>Registre-se como <b class="banner_text">Empresa</b>, e crie projetos!</p>
              </div>
              <div class="text_banner">
                <BotaoVerde />
                <p>Registre-se como <b class="banner_text2">Freelancer</b>, e ajude projetos!</p>
              </div>
            </div>
            <div class="banner_right">
              <img src={bannerPessoas} class="banner_img" alt="" />
            </div>
          </div>
        </div>
      </div>

      <div class="contem_tudo" id="comoFunciona">
        <div class="container">
            <h1> Como funciona? </h1>
            <div class="cont">
                <div class="info">
                    <div class="img">
                        <img src={funciona2} alt="" />
                    </div><br/>
                    <h2>Cadastre-se</h2><br/>
                    <p>Cadastre suas informações em nosso site, como experiências, linguagens que trabalha, portfolio,
                        etc.</p><br/>
                    <a href="#"> Saiba mais </a>
                </div>
                <div class="info">
                    <div class="img">
                        <img src={funciona3} alt="" class="info_img" />
                    </div><br />
                    <h2>Escolha o job</h2><br />
                    <p>Dentre centenas de jobs, escolha o que te interessar, através de recomendações baseadas nos seus
                        conhecimentos e filtros.</p><br />
                    <a href="#"> Saiba mais </a>
                </div>
                <div class="info">
                    <div class="img">
                        <img src={funciona} alt="" />
                    </div><br />
                    <h2>Entregue e receba</h2><br />
                    <p>Entregue o combinado, aumentando sua credibilidade na plataforma e receba o valor combinado 100%
                        garantido.</p><br />
                    <a> Saiba mais </a>
                </div>
            </div>
        </div>
    </div>

    <div class="contem_tudo_ben">
        <div class="container"><br/><br/>
            <h1> Benefícios </h1>
            <div class="cont">
                <div class="info_ben">
                    <div class="img_ben">
                        <img src={beneficio2} alt="" />
                    </div><br/>
                    <h2>Conexões</h2><br/>
                    <p>Conheça pessoas e projetos da sua área de trabalho</p><br/>
                </div>
                <div class="info_ben">
                    <div class="img_ben">
                        <img src={beneficio3} alt="" />
                    </div><br />
                    <h2>Segurança</h2><br />
                    <p>Suporte ativo e segurança no pagamento</p><br />
                </div>
                <div class="info_ben">
                    <div class="img_ben">
                        <img src={beneficio} alt="" />
                    </div><br />
                    <h2>Taxas reduzidas</h2><br />
                    <p>Somos a empresa com as taxas mais baixas do mercado freelancer</p><br />
                </div>
            </div>
        </div>
    </div>

    <div class="contem_tudo">
        <div class="container">
            <div class="contem_tudo_his">
                <div class="cont_img">
                    <img src={mulherHistoria} alt="" />
                </div>
                <div class="cont_historia">
                    <h1> Nossa História </h1>
                    <p>A devfy surge em 2021 com o propósito de intermediar a relação entre desenvolvedores freelancers
                        e empresas, gerando uma relação de confiaça e sucesso para ambas as partes.Temos como pilares
                        confiança, seriedade e empreendedorismo. Surgimos durante a pandemia para facilitar esse setor e
                        promover as relações de trabalho sem vínculo empregatício.</p>
                </div>
            </div>
        </div>
    </div>

    <Footer/>
    </div>
  );
}

export default PaginaInicial;
