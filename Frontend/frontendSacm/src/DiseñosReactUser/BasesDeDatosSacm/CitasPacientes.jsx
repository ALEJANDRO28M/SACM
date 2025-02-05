import { useState, useEffect } from "react";
import "../../img/imagenDeFondo.jpg";
import "../BasesDeDatosSacm/tablesacm.css";

function CitasPacientes() {
  const [citPacientes, setCitPacientes] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  const getColor = (estado) => {
    switch (estado.toLowerCase()) {
      case "completada":
        return "green";
      case "pendiente":
        return "yellow";
      case "cancelada":
        return "red";
      default:
        return "white";
    }
  };

  const fetchDataPacient = async () => {
    try {
      const peticion = await fetch("http://localhost:8080/Api/CitasPacientes", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!peticion.ok) {
        throw new Error("Error en la solicitud");
      }

      const users = await peticion.json();
      
      // Agregar estado inicial a cada cita
      const citasConEstado = users.map((cita) => ({
        ...cita,
        estadoCita: cita.situacion || "pendiente", // Asigna el estado inicial
      }));

      setCitPacientes(citasConEstado);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  const verPaciente_id = async (id) => {

    try {
      const response = await fetch(
        `http://localhost:8080/ApiData/citPatientId/${id}`
      );

      if (!response.ok) {
        throw new Error("Error al obtener el paciente del backend");
      }

      window.location.href = "http://localhost:5173/Paciente";
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleEstadoChange = (id, nuevoEstado) => {
    setCitPacientes((prevCitas) =>
      prevCitas.map((cita) =>
        cita.id === id ? { ...cita, estadoCita: nuevoEstado } : cita
      )
    );
  };

  useEffect(() => {
    fetchDataPacient();
  }, []);

  return (
    <div className="sheet">
      <a href="http://localhost:5173/BasesDeDatos" className="btnIni">INICIO</a>
      <div className="tabla-container-cdhm">
        <table className="tabla_Users_cdhm">
          <thead>
            <tr className="tr_cdhm">
              <th className="th_cdhm">ID</th>
              <th className="th_cdhm">PACIENTE</th>
              <th className="th_cdhm">FECHA</th>
              <th className="th_cdhm">MOTIVO</th>
              <th className="th_cdhm">SITUACION</th>
            </tr>
          </thead>
          <tbody>
            {citPacientes.map((cita) => (
              <tr key={cita.id} className="tr_cdhm-body">
                <td className="td_cdhm">{cita.id}</td>
                <td className="td_cdhm">
                  <button
                    className="btn-ver"
                    onClick={() => verPaciente_id(cita.user_Of_Patients.id)}
                  >
                    ver
                  </button>
                </td>
                <td className="td_cdhm">{cita.fecha}</td>
                <td className="td_cdhm">{cita.motivo}</td>
                <td className="td_cdhm">
                  <select
                    className="seleccionar_sit_cita"
                    value={cita.estadoCita}
                    onChange={(e) => handleEstadoChange(cita.id, e.target.value)}
                    style={{ backgroundColor: getColor(cita.estadoCita) }}
                  >
                    <option className="completada" value="completada">
                      Completada
                    </option>
                    <option className="pendiente" value="pendiente">
                      Pendiente
                    </option>
                    <option className="cancelada" value="cancelada">
                      Cancelada
                    </option>
                  </select>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <button className="btn-volver"><a href="http://localhost:5173/BasesDeDatos">volver</a></button>
      </div>
    </div>
  );
}

export default CitasPacientes;
