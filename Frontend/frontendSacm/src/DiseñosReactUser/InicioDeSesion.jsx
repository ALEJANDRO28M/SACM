import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../css/fondo.css';
import '../css/colores.css';

export default function InicioSesion() {
  // Instanciamos la función de navegación
  const redireccionar = useNavigate();

  // Estados para almacenar el usuario, contraseña y estado del checkbox "Recuérdame"
  const [usuario, setUsuario] = useState('');
  const [password, setPassword] = useState('');
  const [recuerdame, setRecuerdame] = useState(false);

  // Maneja el cambio en el campo de usuario
  const handleUsuarioChange = (e) => {
    setUsuario(e.target.value);
  };

  // Maneja el cambio en el campo de contraseña
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  // Maneja el cambio en el checkbox "Recuérdame"
  const handleRecuerdameChange = (e) => {
    setRecuerdame(e.target.checked);
  };

  // Función para manejar el inicio de sesión
  async function ingresar() {
    try {
      const peticion = await fetch(`http://localhost:8080/api/validarInicio/${usuario}/${password}`);
      
      if (peticion.ok) {
        const resultado = await peticion.json();

        if (resultado === true) {
          alert("¡Bienvenido!");
          window.location.href='http://localhost:5173/prueba';
        } else {
          alert('Usuario o clave incorrectos');
        }
      } else {
        alert('Error al conectar con el servidor');
      }
    } catch (error) {
      console.error('Error en la solicitud:', error);
      alert('Hubo un problema al realizar la solicitud');
    }
  }

  // Maneja el envío del formulario
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Usuario:", usuario);
    console.log("Password:", password);
    console.log("Recuérdame:", recuerdame);
    ingresar(); // Llamar a la función de ingresar al hacer submit
  };

  return (
    <div>
      <h1 className="TituloSesion">BIENVENIDO A SACM</h1>
      <i className="subtituloSesion">Nunca es demasiado tarde para ser lo que podrías haber sido.</i>
      <div className="ContenedorForm">
        <form className="Formulario" onSubmit={handleSubmit}>
          <label htmlFor="usuario" className="LabelsForms">USUARIO</label>
          <input
            type="text"
            id="usuario"
            name="usuario"
            placeholder="Ingrese el usuario"
            value={usuario}
            onChange={handleUsuarioChange}
          />
          <br /><br />
          <a href="#" className="olvido-usuario">¿Olvidaste tu usuario?</a>
          <br /><br />
          <label htmlFor="password" className="LabelsForms">PASSWORD</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Ingrese su contraseña"
            value={password}
            onChange={handlePasswordChange}
          />
          <br /><br />
          <a href="#" className="olvido-usuario">¿Olvidaste tu contraseña?</a>
          <br /><br />
          <input
            type="checkbox"
            id="recuerdame"
            name="recuerdame"
            checked={recuerdame}
            onChange={handleRecuerdameChange}
          />
          <label htmlFor="recuerdame">Recuérdame</label>
          <br /><br /><br /><br />
          <button type="submit" id="ButtonForm">Iniciar Sesión</button>
        </form>
      </div>
      <footer className="creditos">
        <p>© 2024 Luis Alejandro Forero Zapata. Todos los derechos reservados.</p>
      </footer>
    </div>
  );
}
