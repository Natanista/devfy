import './html/css/style.css'
import './html/css/login.css'
import './html/css/menu.css'
import PaginaInicial from './pages/PaginaInicial';
import Dashboard from './pages/Dashboard';
import React from 'react'
import { Router } from 'react-router';

function App() {
  return (
      <div>
        <Dashboard/>
      </div>
  );
}

export default App;
