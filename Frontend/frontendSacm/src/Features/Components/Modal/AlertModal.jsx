import styled from "styled-components";
import React, {useState} from "react";

const AlertModal = ({children,modalConfirm,setModalConfirm}) => {

    return (
        <>

            <Overlay>
                <ContenedorModal>
                    <EncabezadoModal>
                        <TituloModal>Alerta!</TituloModal>
                        <BotonCerrar onClick={() => setModalConfirm(false)}>

                        </BotonCerrar>
                    </EncabezadoModal>
                    <BodyModal>
                    {children}
                    </BodyModal>
                </ContenedorModal>
            </Overlay>
        </>
    )
}
export default AlertModal;


const Overlay = styled.div`
    width: 100vw;
    height: 100vh;
    position: fixed;
    top: 0;
    left: 0;
    padding-top: 3cm;
    padding-bottom: 6cm;
    background: rgba(0,0,0,.5);
    display: flex;
    justify-content: center;
`;

const ContenedorModal = styled.div`
    width: 50%;
    min-height: 390px;
    background: #fff;
    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
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

const BotonCerrar = styled.div`

    width: 30px;
    height: 30px;
    padding-top: 5px;
    margin-left:85%;
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
const TituloModal = styled.h3`
color: black;
`;
const BodyModal = styled.div`
`;