import { useState, useEffect } from "react";

import "../../img/imagenDeFondo.jpg";

function CitasPacientes() {
  const [citPacientes, setcitPacientes] = useState([]);

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
  // Llamada a la API cuando el componente se monta
  useEffect(() => {
    fetchDataPacient();
  }, []); // El array vacío asegura que la llamada se haga solo una vez al montar el componente

  return (
    <div className="tabla-container">
      <h2>Agenda De Citas Medicas</h2>

      <table className="tabla_Users">
        <thead>
          <tr>
            <th>ID</th>
            <th>FECHA</th>
            <th>MOTIVO</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {citPacientes.map((paciente) => (
            <tr key={paciente.id}>
              <td>{paciente.id}</td>
              <td>{paciente.fecha}</td>
              <td>{paciente.motivo}</td>
              <td>DELETE</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default CitasPacientes;
