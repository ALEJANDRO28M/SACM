import { useState, useEffect } from 'react';
import '../css/estiloTablaDatos.css';
import deleteDataUser from './deleteDataUser';

function DatosUser() {
  const [usuarios, setUsuarios] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchData();
  }, []);

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

      const users = await peticion.json();
      setUsuarios(users);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  const eliminarUser = async (id) => {
    try {
      const result = await deleteDataUser(id);
      if (result === 'OK') {
        alert("¡USUARIO ELIMINADO CON ÉXITO!");
        fetchData(); // Refresca datos
      } else {
        alert('ERROR, USUARIO NO ELIMINADO');
      }
    } catch (error) {
      console.error("Error al eliminar el usuario:", error);
    }
  };

  if (error) {
    return <p>Error: {error}</p>;
  }

  if (loading) {
    return <p>Cargando datos...</p>;
  }

  return (
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
            <a href="/BasesSacm.html">Bases de Datos</a>
            <a href="http://localhost:5173/Sacm">Reportes</a>
            <a href="http://localhost:5173/Sacm">Perfil</a>
            <a href="#">Cerrar Sesión</a>
          </nav>
          <label htmlFor="btn-menu">✖️</label>
        </div>
      </div>

      {/* Título y Tabla de usuarios */}
      <h2 className="titulo-usuarios">USUARIOS REGISTRADOS</h2>

      <div className="tabla-usuarios-container">
        <table className="tabla-usuarios">
          <thead>
            <tr className="fila-cabecera-usuarios">
              <th className="celda-cabecera-usuarios">ID</th>
              <th className="celda-cabecera-usuarios">USUARIO</th>
              <th className="celda-cabecera-usuarios">CONTRASEÑA</th>
              <th className="celda-cabecera-usuarios">ACCIONES</th>
            </tr>
          </thead>
          <tbody>
            {usuarios.map((usuario) => (
              <tr key={usuario.id} className="fila-dato-usuarios">
                <td className="celda-dato-usuarios">{usuario.id}</td>
                <td className="celda-dato-usuarios">{usuario.usuario}</td>
                <td className="celda-dato-usuarios">{usuario.password}</td>
                <td className="celda-dato-usuarios">
                  <button
                    className="btn-eliminar-usuario"
                    onClick={() => eliminarUser(usuario.id)}
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default DatosUser;
