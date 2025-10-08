import { useState, useEffect } from "react";
import "../../img/imagenDeFondo.jpg";
import "../BasesDeDatosSacm/tablesacm.css";
import { matchPath, useNavigate } from 'react-router-dom';


function CitasPacientes() {
  
  const [citPacientes, setCitPacientes] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  const[currentPage,setCurrentPage] = useState(1);

  const pageSize = 3;
  const totalPages = Math.ceil(citPacientes.length / pageSize);
  const indiceStart = (currentPage -1) * pageSize;

  const dataView = citPacientes.slice(indiceStart, indiceStart + pageSize);
  
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
      const peticion = await fetch("http://localhost:8080/Api/CityPatient", {
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
      const citasConEstado = users.data.map((cita) => ({
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
      
      console.log(id);

      
      navigate(`/Paciente/${id}`)
 /*   try {
      const response = await fetch(
        `http://localhost:8080/Api/FindByIdUserPatient/${id}`
      );

      if (!response.ok) {
        throw new Error("Error al obtener el paciente del backend");
      }
*/
   //   window.location.href = "http://localhost:5173/Paciente";
   /* } catch (error) {
      console.error("Error:", error);
    }*/
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
            <li><a href="/Nosotros">Nosotros</a></li>
            <li><a href="/Blog.html">Blog</a></li>
            <li><a href="/Contacto.html">Contacto</a></li>
          </ul>
        </nav>
      </header>

      {/* Menú lateral */}
      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="/BasesSacm.html">Bases de Datos</a>
            <a href="/Sacm">Reportes</a>
            <a href="/Sacm">Perfil</a>
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
            {dataView.map((cita) => (
              <tr key={cita.id}>
                <td>{cita.id}</td>
                <td>
                  <button
                    className="btn-ver"
                    onClick={() => verPaciente_id(cita.user.id)}
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
        <div className="ContainerPaginaded">
        <label className='numberPage' id='labelPagened'>{"Pagina: " + currentPage}</label>
        <div className='pagesContainer'>
        <button className='pages' id='back' onClick={() => { if (currentPage >= 2) {
        setCurrentPage(currentPage -1);          
        } }}>back</button>
                <button className='pages' id='next' onClick={() => { if (currentPage <= totalPages) {
        setCurrentPage(currentPage + 1);          
        } }}>next</button>
        </div>
        </div>
            <button className="btn-volver-pacientes">
      <a href="/BasesSacm.html" className="btn-Tables-Volver">Volver</a>
    </button>
      </div>
    </div>
  
  );
}

export default CitasPacientes;
