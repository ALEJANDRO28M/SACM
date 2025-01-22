import { useState, useEffect } from "react";
import "../../css/Bds.css";
import bdImg from "../../css/ImgBds/imgCitasPacientes.jpg"

function BasesDeDatos() {

  return (
    <body>
        <a href="http://localhost:5173/Sacm" id="inicio_Bds">INICIO</a>
      <section className="flexBd_Container">

        <div className="citas_pacientes">
           <a href="http://localhost:5173/datoscitPacient">Bd_CitasPacientes</a>
        </div>
        <div className="doctores">
          <a href="http://localhost:5173/DoctoresBd">Bd_Doctores</a>
        </div>
        <div className="historialmedico">
          <a href="http://localhost:5173/HistoryDoctor">Bd_HistorialMedico</a>
        </div>
        <div className="medicines">
          <a href="http://localhost:5173/Medicines">Bd_Medicinas</a>
        </div>
        <div className="datosUser">
          <a href="http://localhost:5173/HistoryDoctor">Bd_datosUser</a>
        </div>
      </section>
    </body>
  );
}
export default BasesDeDatos;
