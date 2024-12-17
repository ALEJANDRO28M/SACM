import { useState, useEffect } from "react";
import "../../img/imagenDeFondo.jpg";

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

      if (!peticion.ok) {
        throw new Error("Error en la solicitud");
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
        <h2>HISTORIAL MEDICO</h2>

        <table className="tabla_Users">
            <thead>
              <tr>
                <th>ID</th>
                <th>FECHA</th>
                <th>DIAGNOSTICO</th>
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