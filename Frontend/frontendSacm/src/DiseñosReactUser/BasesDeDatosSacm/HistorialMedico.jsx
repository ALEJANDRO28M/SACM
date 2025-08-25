import { useState, useEffect } from "react";
import "../../css/HistoryDoctor.css";

function HistorialMedico() {
  const [listHistorialMedico, setListHistorial] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const controller = new AbortController();

    const fetchDataHistory = async () => {
      try {
        const response = await fetch("http://localhost:8080/Api/HistoryDoctor", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
          signal: controller.signal,
        });

        if (!response.ok) {
          throw new Error("Error en la solicitud");
        }

        const history = await response.json();
        setListHistorial(history);
      } catch (error) {
        if (error.name !== "AbortError") {
          setError(error.message);
        }
      } finally {
        setLoading(false);
      }
    };

    fetchDataHistory();

    return () => controller.abort(); // cancelar fetch al desmontar
  }, []);

  if (loading) return <p>Cargando historial...</p>;
  if (error) return <p>Error: {error}</p>;

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
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contacto</a></li>
          </ul>
        </nav>
      </header>

      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="/BasesSacm">Bases de Datos</a>
            <a href="/Sacm">Reportes</a>
            <a href="/Sacm">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>

      <h2 className="tittlehistorial">HISTORIAL MÉDICO</h2>

      <table className="tabla_Users">
        <thead>
          <tr>
            <th>ID</th>
            <th>FECHA</th>
            <th>DIAGNÓSTICO</th>
            <th>TRATAMIENTO</th>
          </tr>
        </thead>
        <tbody>
          {listHistorialMedico.length === 0 ? (
            <tr>
              <td colSpan="4">No hay historial disponible</td>
            </tr>
          ) : (
            listHistorialMedico.map((historial) => (
              <tr key={historial.id}>
                <td>{historial.id}</td>
                <td>{new Date(historial.fecha).toLocaleDateString()}</td>
                <td>{historial.diagnostico}</td>
                <td>{historial.tratamiento}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>

      <button className="btn-volver-pacientes">
        <a href="/BasesSacm.html" className="btn-Tables-Volver">Volver</a>
      </button>
    </div>
  );
}

export default HistorialMedico;
