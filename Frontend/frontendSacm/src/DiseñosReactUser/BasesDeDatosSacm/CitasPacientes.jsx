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
   <div className="Tabla-Container">
      {/* Menú superior */}
      <header className="header-container-ultimate">
        <div className="btn-menu">
          <label htmlFor="btn-menu" className="icon-menu">SACM</label>
        </div>
        <nav className="menu-ultimate">
          <ul>
            <li><a href="/index.html">Inicio</a></li>
            <li><a href="http://localhost:5173/Nosotros">Nosotros</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contacto</a></li>
          </ul>
        </nav>
      </header>

      {/* Menú lateral */}
      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.htmls">Bases de Datos</a>
            <a href="http://localhost:5173/Sacm">Reportes</a>
            <a href="http://localhost:5173/Sacm">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>

   

      {/* Título */}
      <h2 className="tittle-citas">CITAS MÉDICAS</h2>
      
      {/* Tabla de citas */}
      <div className="tabla-container-citas">
        <table className="tabla-citas">
          <thead className="tabla-citas-head">
            <tr>
              <th>ID</th>
              <th>PACIENTE</th>
              <th>FECHA</th>
              <th>MOTIVO</th>
              <th>SITUACIÓN</th>
            </tr>
          </thead>
          <tbody>
            {citPacientes.map((cita) => (
              <tr key={cita.id}>
                <td>{cita.id}</td>
                <td>
                  <button
                    className="btn-ver"
                    onClick={() => verPaciente_id(cita.user_Of_Patients.id)}
                  >
                    Ver
                  </button>
                </td>
                <td>{cita.fecha}</td>
                <td>{cita.motivo}</td>
                <td>
                  <select
                    className="seleccionar_sit_cita"
                    value={cita.estadoCita}
                    onChange={(e) => handleEstadoChange(cita.id, e.target.value)}
                    style={{ backgroundColor: getColor(cita.estadoCita) }}
                  >
                    <option value="completada">Completada</option>
                    <option value="pendiente">Pendiente</option>
                    <option value="cancelada">Cancelada</option>
                  </select>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  
  );
}

export default CitasPacientes;
