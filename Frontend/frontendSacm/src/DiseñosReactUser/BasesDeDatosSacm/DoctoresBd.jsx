import { useState, useEffect } from "react";
import '../../img/imagenDeFondo.jpg';
import "../../css/doctor.css";

function DoctoresBd() {
  const [listDoctor, setListDoctor] = useState([]); // Estado para la lista de doctores
  const [error, setError] = useState(null); // Estado para manejar errores
  const [loading, setLoading] = useState(true); // Estado para manejar la carga
  const [currentPage, setCurrentPage] = useState(1);
  const pageSize = 2;
  const totalPages = Math.ceil(listDoctor.length / pageSize);
  const indiceStart = (currentPage - 1) * pageSize;
  const dataView = listDoctor.slice(indiceStart,indiceStart + pageSize);

  const fetchDataDoctor = async () => {
    try {
      const peticion = await fetch("http://localhost:8080/Api/DataDoctor", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!peticion.ok) {
        throw new Error("Error en la solicitud");
      }

      const doctores = await peticion.json();
      setListDoctor(doctores.data);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  // Llamada a la API al montar el componente
  useEffect(() => {
    fetchDataDoctor();
  }, []);

  if (loading) {
    return <div className="Tabla-Container">Cargando...</div>;
  }

  if (error) {
    return <div className="Tabla-Container">Error: {error}</div>;
  }

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
            <li><a href="/BlogPerfect">Blog</a></li>
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
            <a href="/PerfilUser">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>

   

      {/* Título */}
      <h2 className="tittle-Doctores">DOCTORES</h2>

      <div className="tabla-container-doctor">
        <table className="tabla_Users_cdhm_doctor">
          <thead>
            <tr className="tr_cdhm_doctor">
              <th className="th_cdhm_doctor">ID</th>
              <th className="th_cdhm_doctor">NOMBRE</th>
              <th className="th_cdhm_doctor">APELLIDO</th>
              <th className="th_cdhm_doctor">ESPECIALIDAD</th>
              <th className="th_cdhm_doctor">TELEFONO</th>
              <th className="th_cdhm_doctor">EMAIL</th>
            </tr>
          </thead>
          <tbody>
            {dataView.map((medico) => ( 
              <tr key={medico.id} className="tr_cdhm-body_doctor">
                <td className="td_cdhm_doctor">{medico.id}</td>
                <td className="td_cdhm_doctor">{medico.nombre}</td>
                <td className="td_cdhm_doctor">{medico.apellido}</td>
                <td className="td_cdhm_doctor">{medico.especialidad}</td>
                <td className="td_cdhm_doctor">{medico.telefono}</td>
                <td className="td_cdhm_doctor">{medico.email}</td>
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

export default DoctoresBd;
