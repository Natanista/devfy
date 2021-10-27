import React from "react";
import logo from '../html/img/LOGO.png';

function Menu() {
  return (
    <div>
      <header class="header">
        <nav>
          <div class="container">
            <img class="logo_img" src={logo} alt="" />
            <ul class="menu_1">
              <li>
                <a href="#">Freelancer</a>
              </li>
              <li>
                <a href="#">Empresa</a>
              </li>
              <li>
                <a href="#comoFunciona">Como funciona</a>
              </li>
            </ul>
            <ul class="menu_2">
              <li>
                <a href="#">Entrar</a>
              </li>
              <li>
                <button class="btn_orange" href="login.html"> Registrar-se </button>
              </li>
            </ul>
          </div>
        </nav>
      </header>
    </div>
  );
}

export default Menu;
