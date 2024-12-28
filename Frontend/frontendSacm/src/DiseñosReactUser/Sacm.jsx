import React from "react";
import "../img/indexBackground.webp";
import "../css/index.css";


function Prueba() {
  return (
    <body>
      <header className="header">
        <div className="container">
          <div className="btn-menu">
            <label htmlFor="btn-menu">☰</label>
          </div>
          <div className="logo">
            <h1>SACM</h1>
          </div>
          <nav className="menu">
            <a href="#">Inicio</a>
            <a href="#">Nosotros</a>
            <a href="#">Blog</a>
            <a href="#">Contacto</a>
          </nav>
        </div>
      </header>
      <div className="capa"></div>
      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="#">Portafolio</a>
            <a href="#">Servicios</a>
            <a href="#">Suscribirse</a>
            <a href="#">Facebook</a>
            <a href="#">Youtube</a>
            <a href="#">Instagram</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>
    </body>
  );
}

export default Prueba;
