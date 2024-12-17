import React from "react";

import '../img/indexBackground.webp';
import '../css/index.css';
import '../css/transiciones.css';
import '../css/Autor_indexBd.css';

function Prueba (){


 

    return( <div className="home-container">
         <nav class="menu-desplegable">
        <ul class="menu-horizontal">
            <li><a href="#">INICIO</a></li>
            <li>
                <a href="#">BASES DE DATOS</a>
                <ul class="menu-vertical">
                    <li><a href="http://localhost:8080/TablaPacientes.html">PACIENTES</a></li>
                    <li><a href="#">CITAS</a></li>
                    <li><a href="http://localhost:5173/datos">USUARIOS</a></li>
                </ul>
            </li>
            <li>
                <a href="">HISTORIALES CLINICOS</a>
                <ul class="menu-vertical">
                    <li><a href="#">PACIENTES CONTRIBUTIVOS</a></li>
                    <li><a href="#">PACIENTES SUBSIDIADOS</a></li>
                </ul>
            </li>
            <li><a href="">PRAGRAMA DE CITAS</a></li>
        </ul>
    </nav>
    <div className="DataUser">
    <ul id="listaSinIndice">

        
        <li>Luis</li>
        <li>alejandro</li>
        <li>forero</li>
        <li>zapata</li>

        </ul>
    </div>
      </div>);
}
export default Prueba;