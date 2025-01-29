import { useState, useEffect } from "react";
import '../../img/imagenDeFondo.jpg';
import '../BasesDeDatosSacm/tablesacm.css'
//INCORPORAR CORS POR TEMAS DE SEGURIDAD
function DoctoresBd() {
  const [ListDoctor, setListDoctor] = useState([]); //MANEJAMOS EL ESTADO CON UN ARRAY VACIO

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
      setListDoctor(doctores);

    } catch (error) {
        setError(error.message); //MANEJA LOS ERRORES SI OCURRE ALGO
    } finally{
        setLoading(false);//Marca que la carga ha terminado
    }
  };

  // Llamallada ala API cuando el compomente se monta 

  useEffect(()=>{
    fetchDataDoctor();
  },[]);// El array vacío asegura que la llamada se haga solo una vez al montar el componente

  return (
  
  <div className="sheet">
     <a href="http://localhost:5173/BasesDeDatos" className="btnIni">INICIO</a>
   <div className="tabla-container-cdhm">
    <h2 id="title-pacientes">Bd-Doctores</h2>
    <table className="tabla_Users-cdhm">
        <thead>
            <tr className="tr_cdhm">
                <th className="th_cdhm">ID</th>
                <th className="th_cdhm">NOMBRE</th>
                <th className="th_cdhm">APELLIDO</th>
                <th className="th_cdhm">ESPECIALIDAD</th>
                <th className="th_cdhm">TELEFONO</th>
                <th className="th_cdhm">EMAIL</th>
            </tr>
        </thead>
        <tbody>
            {ListDoctor.map((medico) => (
            <tr key={medico.id} className="tr_cdhm-body">
                <td className="td_cdhm">{medico.id}</td>
                <td className="td_cdhm">{medico.nombre}</td>
                <td className="td_cdhm">{medico.apellido}</td>
                <td className="td_cdhm">{medico.especialidad}</td>
                <td className="td_cdhm">{medico.telefono}</td>
                <td className="td_cdhm">{medico.email}</td>
            </tr>
))}
        </tbody>
    </table>
    </div>
  </div>
  );
}
export default DoctoresBd;
