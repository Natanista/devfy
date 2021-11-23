import React from 'react'
import {BrowserRouter, Switch, Route} from 'react-router-dom'
import PaginaInicial from './pages/PaginaInicial';
import Dashboard from './pages/Dashboard';
import AddProject from './pages/AddProject';
import ProjectEditor from './pages/ProjectEditor';
import Login from './pages/Login';
import Registrar from './pages/Registrar';
import DashboardEmpresa  from './pages/DashboardEmpresa';

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
               <Route exact path="/registrar" component={Registrar}/>
               <Route exact path="/dashboardEmpresa" component={DashboardEmpresa}/>
               <Route exact path="/cadastrar-projeto" component={AddProject} />
               <Route exact path="/editar-projeto" component={ProjectEditor} />
            </Switch>
        </BrowserRouter>
    );
}

export default Rotas;