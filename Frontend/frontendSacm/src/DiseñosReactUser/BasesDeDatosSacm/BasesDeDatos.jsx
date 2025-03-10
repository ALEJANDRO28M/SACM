import { useState, useEffect } from "react";
import "../../css/Bds.css";
import bdImg from "../../css/ImgBds/imgCitasPacientes.jpg"

function BasesDeDatos() {

  return (
    <body>
        <a href="http://localhost:5173/Sacm" id="inicio_Bds">INICIO</a>
      <section className="flexBd_Container">
        <div class="bds">
           <a href="http://localhost:5173/datoscitPacient">Bd_CitasPacientes</a>
        </div>
        <div class="bds">
          <a href="http://localhost:5173/DoctoresBd">Bd_Doctores</a>
        </div>
        <div className="bds">
          <a href="http://localhost:5173/HistoryDoctor">Bd_HistorialMedico</a>
        </div>
        <div className="bds">
          <a href="http://localhost:5173/Medicamentos">Bd_Medicinas</a>
        </div>
        <div className="bds">
          <a href="http://localhost:5173/datos">Bd_datosUser</a>
        </div>
      </section>
    </body>
  );
}
export default BasesDeDatos;
