import { useState, useEffect } from "react";
import '../../img/imagenDeFondo.jpg';

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
  
  <div className="Tabla-Container">
    <h2>GESTION DE USUARIOS MEDICOS</h2>

    <table className="tabla_Users">
        <thead>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>ESPECIALIDAD</th>
                <th>TELEFONO</th>
                <th>EMAIL</th>
            </tr>
        </thead>
        <tbody>
            {ListDoctor.map((medico) => (
            <tr key={medico.id}>
                <td>{medico.id}</td>
                <td>{medico.nombre}</td>
                <td>{medico.apellido}</td>
                <td>{medico.especialidad}</td>
                <td>{medico.telefono}</td>
                <td>{medico.email}</td>
            </tr>
))}
        </tbody>
    </table>
  </div>
  );
}
export default DoctoresBd;
