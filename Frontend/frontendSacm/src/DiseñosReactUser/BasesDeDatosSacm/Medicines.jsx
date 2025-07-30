import { useState,useEffect } from "react";
import '../../css/Medicamentos.Reset.css';

function Medicines() {


    const[listMedicines,setListMedicines] = useState([]);


    const fetchDataMedicines = async () => {

        try{
        const peticion = await fetch("http://localhost:8080/Api/Medicines",{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
            },
        })
    
    if (!peticion.ok) {
        throw new Error("Error en la solicitud");
    }

    const dataMedicine = await peticion.json();
    setListMedicines(dataMedicine);

        } catch (error) {
            setError(error.message); //MANEJA LOS ERRORES SI OCURRE ALGO
        }
    };

      // Llamallada ala API cuando el compomente se monta 
    useEffect(() => {
        fetchDataMedicines();
    },[]);// El array vacío asegura que la llamada se haga solo una vez al montar el componente

    

    return(

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
<h2 className="tittle-medicamentos">MEDICAMENTOS</h2>

<div className="tabla-container-medicamentos">
  <table className="tabla-medicamentos">
    <thead>
      <tr className="tr-medicamentos">
        <th className="th-medicamentos">ID</th>
        <th className="th-medicamentos">NOMBRE</th>
        <th className="th-medicamentos">DESCRIPCIÓN</th>
        <th className="th-medicamentos">DOSIS</th>
        <th className="th-medicamentos">FRECUENCIA</th>
      </tr>
    </thead>
    <tbody>
      {listMedicines.map((listaSing) => (
        <tr key={listaSing.id} className="tr-body-medicamentos">
          <td className="td-medicamentos">{listaSing.id}</td>
          <td className="td-medicamentos">{listaSing.nombre}</td>
          <td className="td-medicamentos">{listaSing.descripcion}</td>
          <td className="td-medicamentos">{listaSing.dosis}</td>
          <td className="td-medicamentos">{listaSing.frecuencia}</td>
        </tr>
      ))}
    </tbody>
  </table>
        <button className="btn-volver-pacientes">
        <a href="http://localhost:5173/BasesSacm.html" className="btn-Tables-Volver">Volver</a>
      </button>
</div>

        </div>
    );
    
}

export default Medicines;