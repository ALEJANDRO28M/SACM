import { useState, useEffect } from "react";
import '../../img/imagenDeFondo.jpg';
import "../../css/doctor.css";

function DoctoresBd() {
  const [listDoctor, setListDoctor] = useState([]); // Estado para la lista de doctores
  const [error, setError] = useState(null); // Estado para manejar errores
  const [loading, setLoading] = useState(true); // Estado para manejar la carga

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
    return <div className="sheet">Cargando...</div>;
  }

  if (error) {
    return <div className="sheet">Error: {error}</div>;
  }

  return (
    <div className="sheet">
      <a href="http://localhost:5173/BasesDeDatos" className="btnIni">INICIO</a>
      <div className="tabla-container-doctor">
        <h2 id="title-pacientes">Bd-Doctores</h2>
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
            {listDoctor.map((medico) => (
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
      </div>
    </div>
  );
}

export default DoctoresBd;
