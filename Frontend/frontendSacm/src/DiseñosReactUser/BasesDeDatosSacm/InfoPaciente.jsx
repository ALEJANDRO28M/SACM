import { useState, useEffect } from "react";

function InfoPaciente() {
  const [paciente, setPaciente] = useState([]);
  const [error, setError] = useState(null);

  const fetchDataPacient = async () => {
    try {
      const peticion = await fetch("http://localhost:8080/ApiData/MostrarPaciente", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (!peticion.ok) {
        throw new Error("Error en la solicitud");
      }
      const user = await peticion.json();
      console.log("Datos obtenidos:", user);
      setPaciente(Array.isArray(user) ? user : [user]);
    } catch (error) {
      setError(error.message);
    }
  };

  useEffect(() => {
    fetchDataPacient();
  }, []);

  return (
    <div className="sheet">
      <a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.html" className="btnIni">INICIO</a>
      
      <div className="tabla-container-cdhm">
        <h2 id="title-pacientes">Agenda De Citas Medicas</h2>
        
        {error ? (
          <p style={{ color: "red" }}>Error: {error}</p>
        ) : (
          <table className="tabla_Users_cdhm">
            <thead>
              <tr className="tr_cdhm">
                <th className="th_cdhm">ID</th>
                <th className="th_cdhm">NOMBRE</th>
                <th className="th_cdhm">APELLIDO</th>
                <th className="th_cdhm">EMAIL</th>
                <th className="th_cdhm">EDAD</th>
                <th className="th_cdhm">TELEFONO</th>
                <th className="th_cdhm">CC</th>
                <th className="th_cdhm">FECHA DE NACIMIENTO</th>
                <th className="th_cdhm">GENERO</th>
              </tr>
            </thead>
            <tbody>
              {paciente.length > 0 ? (
                paciente.map((pacie) => (
                  <tr key={pacie.id} className="tr_cdhm-body">
                    <td className="td_cdhm">{pacie.id}</td>
                    <td className="td_cdhm">{pacie.nombres}</td>
                    <td className="td_cdhm">{pacie.apellidos}</td>
                    <td className="td_cdhm">{pacie.email}</td>
                    <td className="td_cdhm">{pacie.edad}</td>
                    <td className="td_cdhm">{pacie.telefono}</td>
                    <td className="td_cdhm">{pacie.cc}</td>
                    <td className="td_cdhm">{pacie.fecha_De_Nacimiento}</td>
                    <td className="td_cdhm">{pacie.genero}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="9" className="td_cdhm">No hay datos disponibles</td>
                </tr>
              )}
            </tbody>
          </table>
        )}
           <button className="btn-volver"><a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.html">volver</a></button>
      </div>
    </div>
  );
}

export default InfoPaciente;
