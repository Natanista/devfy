import React from "react";
import Menu from "../components/Menu";
import QuadradoCinzaDaDashboard from "../components/QuadradoCinzaDaDashboard";

function Dashboard(){
    return(
<div>        
    <div>
        <Menu/> 
        
    </div>

    <div>
        <QuadradoCinzaDaDashboard/>
    </div>
</div>
)
}

export default Dashboard;