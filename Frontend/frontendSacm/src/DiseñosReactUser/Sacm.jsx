import React from "react";
import "../img/indexBackground.webp";
import "../css/index.css";
import image1 from '../img/salud1.jpg';
import image2 from '../img/salud2.webp';
import image3 from '../img/salud3.webp';
import image4 from '../img/salud4.jpg';

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
            <a href="#">Bases de Datos</a>
            <a href="#">Reportes</a>
            <a href="#">Citas Pendientes</a>
            <a href="#">Perfil</a>
            <a href="#">Cerrar Sesion</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>
      <div className="container-body">
        <h1>LA SALUD DE NUESTROS PACIENTES ES PRIMORDIAL</h1>
        <br /><br />
        <h3>
        La salud es el pilar de la vida, y en SACM estamos aquí para protegerla. Nos comprometemos a brindar soluciones médicas innovadoras, servicios confiables y un acompañamiento humano para garantizar tu bienestar en cada etapa de la vida. Porque cuidar de ti no es solo nuestra misión, es nuestra pasión.
        </h3>
      </div>
      <section className="container/img">
        <img src={image1} alt="" />
        <img src={image2}alt="" />
        <img src={image3}alt="" />
        <img src={image4} alt="" />
      </section>
    </body>
  );
}

export default Prueba;
