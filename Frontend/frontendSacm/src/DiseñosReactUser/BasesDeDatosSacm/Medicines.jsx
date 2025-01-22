import { useState,useEffect } from "react";

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
            <h2>GESTION DE DATOS DE MEDICINA</h2>

            <table className="tabla_Users">
                <thead>
                 <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>DOSIS</th>
                    <th>FRECUENCIA</th>
                 </tr>
                </thead>
                <tbody>
                    {listMedicines.map((listaSing) => (
                   <tr key={listaSing.id}>
                    <td>{listaSing.id}</td>
                    <td>{listaSing.nombre}</td>
                    <td>{listaSing.descripcion}</td>
                    <td>{listaSing.dosis}</td>
                    <td>{listaSing.frecuencia}</td>
                   </tr>
))}
                </tbody>
            </table>
        </div>
    );
    
}

export default Medicines;