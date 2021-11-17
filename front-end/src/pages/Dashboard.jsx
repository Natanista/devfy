import React from "react";
import MenuLogado from "../components/MenuLogado";
import Footer from "../components/Footer";
import QuadradoCinzaDaDashboard from "../components/QuadradoCinzaDaDashboard";


function Dashboard(){
    return(
<div>        
    <div>
        <MenuLogado/>
    </div>

    <div>
    <QuadradoCinzaDaDashboard/>
    <br />
    </div>
    
    <div>
    <Footer/>
    </div>
</div>
)
}

export default Dashboard;