import React from "react";
import "../img/indexBackground.webp";
import "../css/index.css";
import image1 from "../img/salud1.jpg";
import image2 from "../img/salud2.webp";
import image3 from "../img/salud3.webp";
import image4 from "../img/salud4.jpg";

function Prueba() {
  return (
    <div className="bodySacm-ultimate">
      <header className="header-container-ultimate">
        <div>
          <h2>LOGO</h2>
        </div>
        <nav className="menu-ultimate">
          <ul >
            <ul>
              <li><a href="#">Inicio</a></li>
              <li><a href="#">Nosotros</a></li>
              <li><a href="#">Blog</a></li>
              <li><a href="#">Contacto</a></li>
            </ul>
          </ul>
        </nav>
      </header>
      <main>
        <div>Contenido</div>
      </main>
      <footer className="footer-ultimate">
      <h3 className="textfooter">© 2025 Alejandro Forero - Todos los derechos reservados</h3>
      </footer>
    </div>
  );
}

export default Prueba;
