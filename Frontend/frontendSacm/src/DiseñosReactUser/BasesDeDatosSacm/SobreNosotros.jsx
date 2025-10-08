  import { useState, useEffect } from "react";

  import "../../css/Nostros.css";

  function SobreNosotros() {
    const [numeracion, setNumeracion] = useState("");

    return (
        <div className="Tabla-Container">
                {/* Menú superior */}
        <header className="header-container-ultimate">
          <div className="btn-menu">
            <label htmlFor="btn-menu" className="icon-menu">SACM</label>
          </div>
          <nav className="menu-ultimate">
            <ul>
              <li><a href="/index.html">Inicio</a></li>
              <li><a href="/Nosotros">Nosotros</a></li>
              <li><a href="/BlogPerfect">Blog</a></li>
              <li><a href="/Contacto.html">Contacto</a></li>
            </ul>
          </nav>
        </header>

        {/* Menú lateral */}
        <input type="checkbox" id="btn-menu" />
        <div className="container-menu">
          <div className="cont-menu">
            <nav>
              <a href="/BasesSacm.html">Bases de Datos</a>
              <a href="/Sacm">Reportes</a>
              <a href="/PerfilUser">Perfil</a>
              <a href="#">Cerrar Sesión</a>
            </nav>
            <label htmlFor="btn-menu">✖️</label>
          </div>
        </div>

        <body className="cuerpo_Nosotros">
          <h1 className="title_Nosotros">Sobre Nosotros</h1>
          <section className="home">
            <div className="in-flex">
              <h1 id="SACM"> SACM</h1>
              <br />
              <p>
                Bienvenido a SACM, un proyecto dedicado a mejorar la gestión y el
                manejo de información en el ámbito de las IPS. Nuestra misión es
                proporcionar soluciones innovadoras que simplifiquen procesos,
                optimicen recursos y brinden un mejor servicio a los usuarios.
              </p>
              <p>
                Este proyecto no solo representa una herramienta funcional, sino
                también un reflejo de mi pasión por la programación y el desarrollo
                de software. A través de SACM, quiero demostrar mis habilidades, mi
                compromiso y mi visión de crear soluciones que marquen la
                diferencia.
              </p>
            </div>
            <div className="in-flex">
              <div id="flex-one">
              <h1>Nuestra Misión</h1>
              <p>
          En SACM, nuestra misión es transformar la gestión de información en las IPS mediante el desarrollo de soluciones tecnológicas eficientes, 
          accesibles y seguras. Nos comprometemos a optimizar los procesos administrativos y médicos para mejorar la experiencia de los usuarios 
          y garantizar un manejo efectivo de los datos en el sector salud.
      </p>
              </div>

              <div id="flex-dos">
  <h2 id ="vision-Sacm">Vision</h2>
  <p>Convertirme en un desarrollador de software reconocido por crear soluciones innovadoras y de alta calidad,
    diseñando herramientas como SACM que simplifiquen procesos y aporten valor a sectores clave como la salud.
  </p>
              </div>

              <div id="flex-tres">
              <h3 id="herramientas">Herramientas utilizadas</h3>
  <p>Java SpringBoot, Javascript, React, css, Hibernate, Spring Security, MySql.
  </p>
              </div>
            </div>
          </section>
          
        </body>
        
        </div>
      );
    }
  export default SobreNosotros;
