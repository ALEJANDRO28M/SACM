
import { useState,useEffect } from "react";
import "../css/PerfilDesign.css";
import imgGanster from "../img/imgGanster.jpg";
import imgCardiologia from "../img/imgCard.png";

function Perfil(){

    const [userPerfil,setUserPerfil] = useState({});

 useEffect(() => {

  const saveInfoLocalStorage = localStorage.getItem("doctor");
  console.log(saveInfoLocalStorage)

  if (saveInfoLocalStorage) {
    
    const perfil = JSON.parse(saveInfoLocalStorage);
    setUserPerfil(perfil.doctor);
    
  }
  
}, []);

    return(
        <div className="Tabla-Container">
      <header className="header-container-ultimate">
        <div className="btn-menu">
          <label htmlFor="btn-menu" className="icon-menu">SACM</label>
        </div>

        <nav className="menu-ultimate">
          <ul>
            <li><a href="/index.html">Inicio</a></li>
            <li><a href="/Nosotros">Nosotros</a></li>
            <li><a href="/Blog.html">Blog</a></li>
            <li><a href="/Contacto.html">Contacto</a></li>
          </ul>
        </nav>
      </header>

      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="/BasesSacm.html">Bases de Datos</a>
            <a href="/Sacm">Reportes</a>
            <a href="/Sacm">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>
      <div id="bodyPerfil" >
        <div id="PerfilContainer">
        <div className="perfildetails" id="detailsDivOne">
          <h2 id="titleprofile">Sobre el Perfil</h2>
          <img src={imgGanster} alt="" id="imgProfile"/> 
          

          
           <dl id="listProfile">

            <dt>Nombre:</dt>
            <dd>{userPerfil.nombre + " " + userPerfil.apellido }</dd>

            <dt >Edad:</dt>
            <dd >{userPerfil.edad}</dd>

            <dt>Especialidad:</dt>
            <dd >{userPerfil.especialidad}</dd>

            <dt >Telefono:</dt>
            <dd >{userPerfil.telefono}</dd>

            <dt >Email:</dt>
            <dd>{userPerfil.email}</dd>

          </dl>
          


          </div>
        <div className="perfildetails" id="idperfiltwo">
          <h2 id="about">Sobre mi</h2>
          <p class="parrafperfil">{userPerfil.description}</p>
          <img src={imgCardiologia} alt="" id="imgcard"/>
        </div>
        </div>
      </div>
        </div>
    );
}
export default Perfil;