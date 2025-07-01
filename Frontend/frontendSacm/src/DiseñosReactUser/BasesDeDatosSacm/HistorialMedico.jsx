import { useState, useEffect } from "react";
import "../../img/imagenDeFondo.jpg";
import "../../css/HistoryDoctor.css"

function HistorialMedico() {
  const [ListHistorialMedico, setListHistorial] = useState([]);

  const fetchDataHistory = async () => {

    try {

      const peticion = await fetch(

        "http://localhost:8080/Api/HistoryDoctor",
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
     if(!peticion.ok){
      throw new error("Error en la solicitud");
     }
      
      const history = await peticion.json();
      setListHistorial(history);

    } catch (error) {
        setError(error.message);
    }finally{
        setLoading(false); //MARCA QUE LA CARGA HA TERMINADO 
    }
  };

  useEffect(()=>{
    fetchDataHistory();
  },[]);

  return (

 <div className="Tabla-Container">
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

      <input type="checkbox" id="btn-menu" />
      <div className="container-menu">
        <div className="cont-menu">
          <nav>
            <a href="http://127.0.0.1:5500/frontendSacm/src/DiseñosReactUser/BasesSacm.htmls">Bases de Datos</a>
            <a href="http://localhost:5173/Sacm">Reportes</a>
            <a href="http://localhost:5173/Sacm">Perfil</a>
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
          {ListHistorialMedico.map((HistorialMedico) => (
            <tr key={HistorialMedico.id}>
              <td>{HistorialMedico.id}</td>
              <td>{HistorialMedico.fecha}</td>
              <td>{HistorialMedico.diagnostico}</td>
              <td>{HistorialMedico.tratamiento}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default HistorialMedico;