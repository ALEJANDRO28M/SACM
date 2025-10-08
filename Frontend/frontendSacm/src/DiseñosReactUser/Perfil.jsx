//HOOKS
import {useEffect, useState} from "react";
import ModalV from "../Modal/ModalV.jsx";
import "../css/PerfilDesign.css";

//IMAGENES IMPORTADAS
import imgGanster from "../img/imgGanster.jpg";
import imgCardiologia from "../img/imgCard.png";
import editIcon from "../img/boligrafo.png";

//STYLES COMPONENTS
import styled from 'styled-components';


function Perfil() {

    const [userPerfil, setUserPerfil] = useState({});
    const [estadoModal, setearEstadoModal] = useState(false);

    useEffect(() => {

        const saveInfoLocalStorage = localStorage.getItem("doctor");
        console.log(saveInfoLocalStorage)

        if (saveInfoLocalStorage) {

            const perfil = JSON.parse(saveInfoLocalStorage);
            setUserPerfil(perfil.doctor);

        }

    }, []);


    const BotonEditar = styled.button`
        position: static;
        transition: transform 0.3s ease-in-out;
        background-color: transparent;
        margin: auto;
        width: 60px;
        height: 60px;

        &:hover {
            transform: scale(1.20); /* efecto zoom al pasar el mouse */
            background-color: transparent;
            border-radius: 70px;
        }
    `;


    return (
        <div className="Tabla-Container">
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

            <input type="checkbox" id="btn-menu"/>
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
            <div id="bodyPerfil">
                <div id="PerfilContainer">
                    <div className="perfildetails" id="detailsDivOne">
                        <h2 id="titleprofile">Sobre el Perfil</h2>
                        <img src={imgGanster} alt="" id="imgProfile"/>

                        <div className="listContainerUserEdit">

                            <dl id="listProfile">

                                <dt>Nombre:</dt>
                                <dd>{userPerfil.nombre + " " + userPerfil.apellido}</dd>

                                <dt>Edad:</dt>
                                <dd>{userPerfil.edad}</dd>

                                <dt>Especialidad:</dt>
                                <dd>{userPerfil.especialidad}</dd>

                                <dt>Telefono:</dt>
                                <dd>{userPerfil.telefono}</dd>

                                <dt>Email:</dt>
                                <dd>{userPerfil.email}</dd>
                            </dl>

                            <BotonEditar onClick={() => setearEstadoModal(true)}>
                                <img src={editIcon} alt="" id="editImg"/>
                            </BotonEditar>
                        </div>

                    </div>
                    <div className="perfildetails" id="idperfiltwo">
                        <h2 id="about">Sobre mi</h2>
                        <p className="parrafperfil">{userPerfil.description}</p>
                        <img src={imgCardiologia} alt="" id="imgcard"/>
                    </div>
                    <ModalV
                    estado = {estadoModal}
                    cambiarEstado = {setearEstadoModal}>
                                <Contenido>
                            <form >
                                <label>Nombre</label>
                                <input placeholder="Ingrese Nombre"></input>
                                <label>Especialidad</label>
                                <input placeholder="Ingrese Especialidad"></input>
                                <label>Telefono</label>
                                <input placeholder="Ingrese Numero de Telefono"></input>
                                <label>Email</label>
                                <input placeholder="Ingrese Email"></input>
                                <button type="submit">Guardar</button>
                            </form>
                                </Contenido>
                    </ModalV>
                </div>
            </div>
        </div>
    );
}

export default Perfil;

const Contenido = styled.div`
display: flex`;