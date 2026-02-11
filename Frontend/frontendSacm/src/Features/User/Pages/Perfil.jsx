//HOOKS
import {useEffect, useState} from "react";
import ModalV from "../../Components/Modal/ModalV.jsx";
import "../../../css/Perfil_Css/PerfilDesign.css";
import {PhoneInput} from 'react-international-phone';
import 'react-international-phone/style.css';

//IMAGENES IMPORTADAS
import imgCheck from "../../../assets/img/Perfil_Img/gifsImg/checkmark.gif";
import imgGanster from "../../../assets/img/Perfil_Img/imgGanster.jpg";
import imgCardiologia from "../../../assets/img/Perfil_Img/imgCard.png";
import editIcon from "../../../assets/img/Perfil_Img/boligrafo.png";

//STYLES COMPONENTS
import styled,{keyframes} from 'styled-components';
import AlertModal from "../../Components/Modal/AlertModal.jsx";


function Perfil() {
// 1. CONFIGURACIÓN INICIAL
    const token = localStorage.getItem("token");
    console.log("Token recibido de InicioDeSesion:", token);

// 2. HOOKS DE ESTADO
    const [userPerfil, setUserPerfil] = useState({});
    const [estadoModal, setearEstadoModal] = useState(false);
    const [modalConfirm, setModalConfirm] = useState(false);

    const [id, setId] = useState(null);
    const [edad, setEdad] = useState(null);
    const [nombre, setNombre] = useState(null);
    const [apellido, setApellido] = useState(null);
    const [especialidad, setEspecialidad] = useState(null);
    const [telefono, setTelefono] = useState(null);
    const [email, setEmail] = useState(null);
    const [description, setDescription] = useState(null);

// 3. FUNCIONES DE NEGOCIO (API)

// 3.1 Obtener perfil desde el token
    const infoClaims = async () => {
        try {
            const peticion = await fetch("http://localhost:8080/Api/Profile", {
                method: "GET",
                credentials: "include",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                }
            });

            if (peticion.ok) {
                const getPerfil = await peticion.json();

                // Actualizar estados con datos del perfil
                setUserPerfil(getPerfil.nombre);
                setId(getPerfil.id);
                setNombre(getPerfil.nombre || "");
                setApellido(getPerfil.apellido || "");
                setEdad(getPerfil.edad);
                setEspecialidad(getPerfil.especialidad || "");
                setTelefono(getPerfil.telefono || "");
                setEmail(getPerfil.email || "");
                setDescription(getPerfil.description);

                console.log(nombre);
            }
        } catch (error) {
            console.error("Error al procesar token:", error);
        }
    };

// 3.2 Actualizar perfil (POST)
    const apiFetch = async () => {
        try {
            const peticion = await fetch("http://localhost:8080/Api/UpdateDoctor", {
                method: "POST",
                credentials: "include",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                },
                body: JSON.stringify({ id, nombre, apellido, especialidad, telefono, email })
            });

            if (peticion.ok) {
                const newToken = await peticion.json();
                // Mostrar confirmación
                setTimeout(() => {
                    setModalConfirm(true);
                }, 400);

                setUserPerfil(newToken.data);
            }
        } catch (error) {
            console.error("Error en la solicitud:", error);
            alert("Hubo un problema al realizar la solicitud");
        }
    };

// 4. EFECTOS
    useEffect(() => {
        infoClaims();
    }, []);

// 5. COMPONENTES/ESTILOS
    const BotonEditar = styled.button`
        position: static;
        transition: transform 0.3s ease-in-out;
        background-color: transparent;
        margin: auto;
        width: 60px;
        height: 60px;

        &:hover {
            transform: scale(1.20);
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
                                <dd>{nombre + " " + apellido}</dd>

                                <dt>Edad:</dt>
                                <dd>{edad}</dd>

                                <dt>Especialidad:</dt>
                                <dd>{especialidad}</dd>

                                <dt>Telefono:</dt>
                                <dd>{telefono}</dd>

                                <dt>Email:</dt>
                                <dd>{email}</dd>
                            </dl>

                            <BotonEditar onClick={() => setearEstadoModal(true)}>
                                <img src={editIcon} alt="" id="editImg"/>
                            </BotonEditar>
                        </div>

                    </div>
                    <div className="perfildetails" id="idperfiltwo">
                        <h2 id="about">Sobre mi</h2>
                        <p className="parrafperfil">{description}</p>
                        <img src={imgCardiologia} alt="" id="imgcard"/>
                    </div>
                    <ModalV
                        estado={estadoModal}
                        cambiarEstado={setearEstadoModal}>
                        <Contenido>
                            <form onSubmit={(e) => {
                                e.preventDefault();
                                apiFetch();
                            }}>
                                <label>Nombre</label>
                                <input
                                    type="text"
                                    value={nombre}
                                    onChange={(e) => setNombre(e.target.value)}
                                />

                                <label>Apellido</label>
                                <input
                                    type="text"
                                    value={apellido}
                                    onChange={(e) => setApellido(e.target.value)}
                                />

                                <label>Especialidad</label>
                                <input
                                    type="text"
                                    value={especialidad}
                                    onChange={(e) => setEspecialidad(e.target.value)}
                                />
                                <label>Teléfono</label>
                                <PhoneInput
                                    defaultCountry="CO"
                                    value={telefono}
                                    onChange={setTelefono}
                                />
                                <label>Email</label>
                                <input
                                    type="email"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                                <button type="submit">Guardar</button>
                            </form>
                        </Contenido>
                    </ModalV>

                    {modalConfirm && (
                        <AlertModal estado={modalConfirm} cambiarEstado={setModalConfirm}>
                            <ContenidoModal>
                                <CheckImg src={imgCheck} />
                                <Mensaje>Usuario modificado con éxito!</Mensaje>
                                <button id="CheckAccept" onClick={() => setModalConfirm(false)}>
                                    Aceptar
                                </button>
                            </ContenidoModal>
                        </AlertModal>
                        )}
                </div>
            </div>
        </div>
    );
}

export default Perfil;
// Animación de entrada con zoom y opacidad
const animacionEntrada = keyframes`
  0% {
    opacity: 0;
    transform: scale(0.8);
  }
  100% {
    opacity: 1;
    transform: scale(1);
  }
`;

const Contenido = styled.div`
    display: flex`
;

const ContenidoModal = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    animation: ${animacionEntrada} 0.6s ease-out;
`;

const CheckImg = styled.img`
margin: 0;
`;

const Mensaje = styled.h3`
color: black;
`;

