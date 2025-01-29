import { useState, useEffect } from "react";
import "../../img/imagenDeFondo.jpg";
import "../BasesDeDatosSacm/tablesacm.css";

function CitasPacientes() {
  const [citPacientes, setcitPacientes] = useState([]);
  const [error, setError] = useState(null); // Estado para manejar errores
  const [loading, setLoading] = useState(true); // Estado para manejar la carga de datos

  // Función para obtener citas de pacientes
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
      const users = await peticion.json(); // Espera a que la promesa se resuelva
      setcitPacientes(users); // Actualiza el estado con los datos
    } catch (error) {
      setError(error.message); // Maneja errores si ocurre alguno
    } finally {
      setLoading(false); // Marca que la carga ha terminado
    }
  };

  // Función para ver detalles de un paciente específico
// Función para ver detalles de un paciente específico
const verPaciente_id = async (id) => {
  alert(id);  // Para verificar que el ID se pasa correctamente
  try {
    // Hacemos la solicitud GET, pasando el ID directamente en la URL
    const response = await fetch(`http://localhost:8080/ApiData/citPatientId/${id}`);

    if (!response.ok) {
      throw new Error("Error al obtener el paciente del backend");
    }
    
    const result = await response.json(); // Suponemos que el backend devuelve la respuesta
    console.log("Datos obtenidos correctamente:", result);

    // Redirigir a una nueva página donde se muestran los datos del paciente
   // window.location.href = "http://localhost:5173/DetallePaciente";  // Redirigir después de recibir la respuesta
  } catch (error) {
    console.error("Error:", error);
  }
};


  // Llamada a la API cuando el componente se monta
  useEffect(() => {
    fetchDataPacient();
    console.log(citPacientes); // Verifica la estructura de los datos
  }, []); // El array vacío asegura que la llamada se haga solo una vez al montar el componente

  // El return aquí es donde finalmente se renderiza el JSX con la tabla
  return (
    <div className="sheet">
      <a href="http://localhost:5173/BasesDeDatos" className="btnIni">INICIO</a>
      <div className="tabla-container-cdhm">
        <h2 id="title-pacientes">Agenda De Citas Medicas</h2>
        <table className="tabla_Users_cdhm">
          <thead>
            <tr className="tr_cdhm">
              <th className="th_cdhm">ID</th>
              <th className="th_cdhm">PACIENTE</th>
              <th className="th_cdhm">FECHA</th>
              <th className="th_cdhm">MOTIVO</th>
              <th className="th_cdhm">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {citPacientes.map((cita) => (
              <tr key={cita.id} className="tr_cdhm-body">
                <td className="td_cdhm">{cita.id}</td>
                <td className="td_cdhm">
                  <button className="btn-ver" onClick={() => verPaciente_id(cita.user_Of_Patients.id)}>
                    ver
                  </button>
                </td>
                <td className="td_cdhm">{cita.fecha}</td>
                <td className="td_cdhm">{cita.motivo}</td>
                <td className="td_cdhm">DELETE</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default CitasPacientes;
