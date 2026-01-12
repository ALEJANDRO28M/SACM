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


    useEffect(() => {

        const saveInfoLocalStorage = localStorage.getItem("doctor");
        console.log(saveInfoLocalStorage)

        if (saveInfoLocalStorage) {

            const getPerfil = JSON.parse(saveInfoLocalStorage);
            setUserPerfil(getPerfil.doctor);
            setId(getPerfil.doctor.id);
            setNombre(getPerfil.doctor.nombre || "");
            setApellido(getPerfil.doctor.apellido || "");
            setEspecialidad(getPerfil.doctor.especialidad || "");
            setTelefono(getPerfil.doctor.telefono || "");
            setEmail(getPerfil.doctor.email || "");
        }

    }, []);


    const [userPerfil, setUserPerfil] = useState({});
    const [estadoModal, setearEstadoModal] = useState(false);
    const [modalConfirm, setModalConfirm] = useState(false);
    const [id, setId] = useState(null);
    const [nombre, setNombre] = useState(null);
    const [apellido, setApellido] = useState(null);
    const [especialidad, setEspecialidad] = useState(null);
    const [telefono, setTelefono] = useState(null);
    const [email, setEmail] = useState(null);


    const apiFetch = async () => {

        try {
            const peticion = await fetch("http://localhost:8080/Api/UpdateDoctor", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({id, nombre, apellido, especialidad, telefono, email})
            });
            if (peticion.ok) {
                const savedPeticion = await peticion.json();
                setTimeout(() =>{
                    setModalConfirm(true)
                },400);
                setUserPerfil(savedPeticion.data);
            }
        } catch (error) {
            console.error('Error en la solicitud:', error);
            alert('Hubo un problema al realizar la solicitud');
        }
    };

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
                    {modalConfirm &&
                    <AlertModal
                    >
                        <ContenidoModal>
                            <CheckImg src={imgCheck}/>
                            <Mensaje>Usuario Modificado con exito!</Mensaje>
                            <button id="CheckAccept" onClick={() => setModalConfirm(false)}>Aceptar</button>
                        </ContenidoModal>
                    </AlertModal>
                    }
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

