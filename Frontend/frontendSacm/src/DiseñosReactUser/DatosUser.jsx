import { useState, useEffect } from 'react';
import '../css/estiloTablaDatos.css';
import deleteDataUser from './deleteDataUser';
import '../css/index.css'
import "../css/mediaQuerySacm.css"


function DatosUser() {
    const [usuarios, setUsuarios] = useState([]); // Estado inicial como un arreglo vacío
    const [loading, setLoading] = useState(true); // Controla el estado de carga
    const [error, setError] = useState(null); // Estado para manejar errores

    useEffect(() => {
        fetchData(); // Llamar a la función al montar el componente
    }, []); // Solo ejecuta el efecto una vez al cargar

    const fetchData = async () => {
        try {
            const peticion = await fetch('http://localhost:8080/Api/Data', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            if (!peticion.ok) {
                throw new Error('Error en la solicitud');
            }

            const users = await peticion.json(); // Espera a que la promesa se resuelva
            setUsuarios(users); // Actualiza el estado con los datos
        } catch (error) {
            setError(error.message); // Maneja errores si ocurre alguno
        } finally {
            setLoading(false); // Marca que la carga ha terminado
        }
    };

    const eliminarUser = async (id) => {
        try {
            const result = await deleteDataUser(id);
            if (result === 'OK') {
                alert("USUARIO ELIMINADO CON EXITO!");
                fetchData(); // Volver a llamar la función para traer los datos actualizados
            } else {
                alert('ERROR, USUARIO NO ELIMINADO');
            }
        } catch (error) {
            console.error("Error al eliminar el usuario:", error);
        }
    };

    // Si hay un error, mostrarlo
    if (error) {
        return <p>Error: {error}</p>;
    }

    // Mostrar mensaje de carga mientras los datos no están listos
    if (loading) {
        return <p>Cargando datos...</p>;
    }


    // Renderizar la tabla cuando los datos estén listos
    return (
       <body>
  <header class="header-container-ultimate">
    <div class="btn-menu">
      <label for="btn-menu" class="icon-menu">SACM</label>    </div>
    <nav class="menu-ultimate">
      <ul >
        <ul>
          <li><a href="#">Inicio</a></li>
          <li><a href="http://localhost:5173/Nosotros">Nosotros</a></li>
          <li><a href="#">Blog</a></li>
          <li><a href="#">Contacto</a></li>
        </ul>
      </ul>
    </nav>
  </header>
  <input type="checkbox" id="btn-menu" />
  <div class="container-menu">
    <div class="cont-menu">
      <nav>
        <a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.html">Bases de Datos</a>
        <a href="http://localhost:5173/Sacm">Reportes</a>
        <a href="http://localhost:5173/Sacm">Perfil</a>
        <a href="#">Cerrar Sesión</a>
      </nav>
      <label for="btn-menu">✖️</label>
    </div>
  </div>
         <div className="tabla-container-dataUser">
            <h2 className='listUserDataText'>Listado de usuarios</h2>
        <table className="tabla_Users">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>password</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                {usuarios.map((usuario) => (
                    <tr key={usuario.id} >
                        <td>{usuario.id}</td>
                        <td>{usuario.usuario}</td>
                        <td>{usuario.password}</td>
                        <td>
                            <button onClick={() => eliminarUser(usuario.id)}>Eliminar</button> {/* Botón de eliminar */}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
        <br/>
        <button><a href="http://127.0.0.1:5500/frontendSacm/src/Dise%C3%B1osReactUser/BasesSacm.html">Volver</a></button>
        </div>
       </body>
    );
}

export default DatosUser;
