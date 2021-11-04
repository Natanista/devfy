import React from 'react'
import {BrowserRouter, Switch, Route} from 'react-router-dom'
import PaginaInicial from './pages/PaginaInicial';
import Dashboard from './pages/Dashboard';
import Login from './pages/Login'
import PaginaNaoEncontrada from './pages/PaginaNaoEncontrada';

//BrowserRouter: da acesso para usar os recursos de rotas
//Switch: permite navegar entre as rotas
//Route : cria a rota em si

function Rotas(){
    return(
        <BrowserRouter>
            <Switch>
               <Route exact path="/" component={PaginaInicial}/> 
               <Route exact path="/dashboard" component={Dashboard}/>
               <Route exact path="/login" component={Login}/>
               <Route exact path="*" component={PaginaNaoEncontrada}/>
            </Switch>
        </BrowserRouter>
    );
}

export default Rotas;