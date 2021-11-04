import React from "react";
import Menu from "../components/Menu";
import Footer from "../components/Footer";
import QuadradoCinzaDaDashboard from "../components/QuadradoCinzaDaDashboard";


function Dashboard(){
    return(
<div>        
    <div>
        <Menu/>
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