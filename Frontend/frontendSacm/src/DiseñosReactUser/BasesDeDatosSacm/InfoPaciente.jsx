import { useState, useEffect } from "react";
import "../../css/Pacienteinfo.css";
import { useParams } from 'react-router-dom';

function InfoPaciente() {
  const [paciente, setPaciente] = useState([]);
  const [error, setError] = useState(null);
  const { id } = useParams(); // Extrae el ID desde la URL

  useEffect(() => {
    const obtenerPaciente = async () => {
      try {
        const peticion = await fetch(`http://localhost:8080/Api/FindByIdUserPatient/${id}`, {
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

        // Asegura que el estado sea siempre un array
        setPaciente([user.data]);
      } catch (error) {
        setError(error.message);
      }
    };

    obtenerPaciente();
  }, [id]);

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
            <a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.html">Bases de Datos</a>
            <a href="http://localhost:5173/Sacm">Reportes</a>
            <a href="http://localhost:5173/Sacm">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>

      {/* Título principal */}
      <h2 className="titulo-pacientes">PACIENTES</h2>

      <div className="tabla-container-pacientes">
        <h2 className="subtitulo-pacientes">Agenda de Citas Médicas</h2>

        {error ? (
          <p className="mensaje-error">Error: {error}</p>
        ) : (
          <table className="tabla-pacientes">
            <thead>
              <tr className="fila-cabecera-pacientes">
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>EMAIL</th>
                <th>EDAD</th>
                <th>TELÉFONO</th>
                <th>CC</th>
                <th>FECHA DE NACIMIENTO</th>
                <th>GÉNERO</th>
              </tr>
            </thead>
            <tbody>
              {paciente.length > 0 ? (
                paciente.map((pacie) => (
                  <tr key={pacie.id} className="fila-dato-pacientes">
                    <td>{pacie.id}</td>
                    <td>{pacie.nombres}</td>
                    <td>{pacie.apellidos}</td>
                    <td>{pacie.email}</td>
                    <td>{pacie.edad}</td>
                    <td>{pacie.telefono}</td>
                    <td>{pacie.cc}</td>
                    <td>{pacie.fecha_Nacimiento}</td>
                    <td>{pacie.genero}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="9" className="sin-datos-pacientes">No hay datos disponibles</td>
                </tr>
              )}
            </tbody>
          </table>
        )}

        <button className="btn-volver-pacientes">
          <a href="http://localhost:5173/datoscitPacient" className="btn-Tables-Volver">Volver</a>
        </button>
      </div>
    </div>
  );
}

export default InfoPaciente;
