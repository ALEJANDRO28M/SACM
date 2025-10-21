import React from "react";
import {useState} from "react";
import styled from "styled-components";
import "../css/BlogDesing.css";
import sectionOne from "../img/sectionimgOne.png";
import sectionTwo from "../img/SectionTwoImg.png"
import sectionThree from "../img/SectionThreeImg.png";
import ModalBlog from "../Modal/ModalBlog.jsx";

function BlogSacm() {

    const [ModalActivo,setModalActivo] = useState(null);

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
            <div className="containerbodyblog">
                <h1 id="titleBlog">BLOG SACM</h1>
                <div className="sectioninformationblog">
                    <div className="sections">
                        <ImgSectionContainer className = "containerimgBlog">
                        <img src={sectionOne} alt="" className="imgSectionBlog"/>
                        </ImgSectionContainer>
                        <p className="parraf">La transformación digital en nuestra IPS no solo
                            mejora procesos, sino que humaniza la atención. Esta imagen
                            representa el inicio de una nueva etapa: plataformas que conectan,
                            simplifican y potencian el trabajo clínico. Desde la arquitectura
                            hasta la experiencia visual, cada detalle está pensado para
                            generar impacto real en la vida de los pacientes. </p>
                        <button className="btnBlogAbrir" onClick={() => setModalActivo(1)}>leer mas..</button>
                        <ModalBlog
                        estado = {ModalActivo === 1}
                        cambiarEstado = {()=>setModalActivo(null)}
                        >
                            <p className="textoExtra" >
                                Desde la arquitectura hasta la experiencia visual, cada detalle está pensado para
                                generar impacto real en la vida de los pacientes.
                                La digitalización en salud no es solo eficiencia: es cercanía.
                                Al integrar herramientas tecnológicas en nuestra IPS, fortalecemos
                                el vínculo entre profesionales y pacientes, agilizamos procesos y
                                elevamos la calidad del servicio. Apostamos por una atención más humana,
                                respaldada por sistemas que entienden, responden y cuidan.
                            </p>
                        </ModalBlog>
                    </div>
                    <div className="sections">
                        <ImgSectionContainer className = "containerimgBlog">
                        <img src={sectionTwo} alt="" className="imgSectionBlog"/>
                        </ImgSectionContainer>
                        <p className="parraf">Cada dato clínico, cada reporte y cada
                            métrica tienen un propósito: mejorar la atención médica.
                            Esta imagen refleja el compromiso de nuestra IPS con
                            diagnósticos precisos, decisiones informadas y procesos ágiles.
                            La tecnología se convierte en aliada del equipo médico,
                            fortaleciendo la gestión y garantizando calidad en cada paso
                            del cuidado de la salud.</p>
                        <button className="btnBlogAbrir" onClick={() => setModalActivo(2)}>leer mas..</button>
                        <ModalBlog
                        estado={ModalActivo === 2}
                        cambiarEstado = {()=>setModalActivo(null)}
                        >
                        <p className="textoExtra" >
                            Tecnología que respalda, decisiones que salvan En cada laboratorio,
                            detrás de cada análisis, hay un equipo que confía en herramientas
                            precisas para cuidar mejor. Nuestra IPS integra soluciones digitales
                            que permiten interpretar datos clínicos con rapidez y claridad,
                            optimizando diagnósticos y fortaleciendo la toma de decisiones médicas.
                            Porque la salud exige rigor, y la tecnología puede ofrecerlo con humanidad.
                        </p>
                        </ModalBlog>
                    </div>
                    <div className="sections">
                        <ImgSectionContainer className = "containerimgBlog">
                        <img src={sectionThree} alt="" className="imgSectionBlog"/>
                        </ImgSectionContainer>
                        <p className="parraf">Cada tratamiento comienza con una decisión informada
                            y un acto de confianza. En nuestra IPS, el acceso seguro y
                            responsable a los medicamentos es parte esencial del cuidado
                            integral. Esta imagen representa el compromiso de nuestros
                            profesionales con la salud de cada paciente, desde la entrega precisa hasta
                            acompañamiento humano y personalizado.</p>
                        <button className="btnBlogAbrir" onClick={() => setModalActivo(3)}>leer mas..</button>
                        <ModalBlog
                        estado={ModalActivo===3}
                        cambiarEstado={()=> setModalActivo(null)}
                        >
                        <p className="textoExtra" >
                            Confianza que sana, cuidado que acompaña Cada cápsula entregada
                            representa más que un tratamiento: es parte de una historia de bienestar.
                            En nuestra IPS, el acceso a medicamentos está respaldado por protocolos seguros,
                            trazabilidad y acompañamiento profesional. Porque cuidar no es solo
                            entregar, es entender, orientar y estar presentes en cada paso del proceso
                            terapéutico.
                        </p>
                        </ModalBlog>

                    </div>
                </div>
            </div>
        </div>);
}
export default BlogSacm;

const ImgSectionContainer = styled.div`
padding-top: 40px;
width: 70%;

`;