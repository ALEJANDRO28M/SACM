import { useState,useEffect } from "react";
import '../../css/Medicamentos.Reset.css';

function Medicines() {

    const[listMedicines,setListMedicines] = useState([]);
    const [currentPage,setCurrentPage] = useState(1);
    const pageSize = 2;
    const totalPages = Math.ceil(listMedicines.length / pageSize);
    const indiceStart = (currentPage-1)*pageSize; 
    const dataView = listMedicines.slice(indiceStart,indiceStart + pageSize);

    const fetchDataMedicines = async () => {

        try{
        const peticion = await fetch("http://localhost:8080/Api/findAllMedicines",{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
            },
        })
    
    if (!peticion.ok) {
        throw new Error("Error en la solicitud");
    }

    const dataMedicine = await peticion.json();
    setListMedicines(dataMedicine.data);

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
      {dataView.map((listaSing) => (
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
        <a href="http://localhost:5173/BasesSacm.html" className="btn-Tables-Volver">Volver</a>
      </button>
</div>
        </div>
    );
    
}

export default Medicines;