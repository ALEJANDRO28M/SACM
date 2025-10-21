import React from "react";
import styled from "styled-components";

const ModalBlog = ({children,estado,cambiarEstado}) => {
    return (
        <>
            {estado &&
            <Overlay>
                <ContenedorModal>
                   <EncabezadoModal>
                       <Sacm>SACM</Sacm>
                       <BotonCerrar onClick={cambiarEstado}>
                           <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                className="bi bi-x-lg" viewBox="0 0 16 16">
                               <path
                                   d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
                           </svg>
                       </BotonCerrar>
                   </EncabezadoModal>
                    {children}
                </ContenedorModal>
            </Overlay>
            }
        </>);


}
export default ModalBlog;

const Overlay = styled.div`
    width: 100vw;
    height: 100vh;
    position: fixed;
    top:0;
    left: 0;
    padding-top: 3cm;
    padding-bottom: 6cm;
    background: rgba(0,0,0,.5);
    display: flex;
    
    justify-content: center;
`;
const ContenedorModal = styled.div`
    width: 70%;
    min-height: 100px;
    background: #fff;
    border-radius: 5px;
    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    @media screen and (max-width: 500px) {
        min-height: 400px;
    }
    @media screen and (max-width: 460px){
        min-height:450px;
    }
    @media screen and (max-width: 370px){
        min-height: 550px;
    }
    @media screen and (max-width: 300px){
        min-height: 600px;
    }
`;

const EncabezadoModal = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 10px;
    margin-bottom: 10px;
    padding-bottom: 20px;
    border-bottom: 1px solid #E8E8E8;
`;
const Sacm = styled.div`
    color: black;
`;
const BotonCerrar = styled.button`

    width: 30px;
    height: 30px;
    padding: 0;
    margin-left:90%;
    border: none;
    background: none;
    cursor: pointer;
    transition: .3s ease all;
    border-radius: 5px;

    color: #1766DC;
    
    @media screen and (max-width: 1200px){
        margin-left: 85%;
    }
    @media screen and (max-width: 850px){
        margin-left: 80%;
    }
    @media screen and (max-width: 700px){
        margin-left: 80%;
    }
    @media screen and (max-width: 650px){
        margin-left: 75%;
    }
    @media screen and (max-width: 550px){
        margin-left: 70%;
    }
    @media screen and (max-width: 450px){
        margin-left: 65%;
    }
    @media screen and (max-width: 380px){
        margin-left: 60%;
    }
    @media screen and (max-width: 300px){
        margin-left: 55%;
    }
    @media screen and (max-width: 270px){
        margin-left: 50%;
    }
    @media screen and (max-width: 230px){
        margin-left: 45%;
    }
    @media screen and (max-width: 210px){
        margin-left: 20%;
    }
`;
