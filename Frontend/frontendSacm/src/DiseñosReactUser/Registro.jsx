// Importar el hook useState de React para manejar el estado local del componente
import { useState } from 'react'; 

// Importar los estilos personalizados para el componente de registro
import '../css/Registros.css'; 

// Importar la función useNavigate del enrutador para redireccionar después del registro
import { useNavigate } from 'react-router-dom';

// Importar la imagen del logo SACM
import imgSacm from '../css/SACM.png';

// Definición del componente funcional Registro
function Registro() {

  // Estados para manejar los valores del formulario
  const [usuario, setUsuario] = useState(''); // Estado para el nombre de usuario
  const [correo, setCorreo] = useState(''); // Estado para el correo electrónico
  const [password, setPassword] = useState(''); // Estado para la contraseña
  const [confirmPassword, setConfirmPassword] = useState(''); // Estado para confirmar la contraseña

  // Función general para manejar los cambios en los inputs
  const handleInputChange = (setter) => (event) => {
    setter(event.target.value); // Cambia el valor del estado asociado
  };

  // Hook para redireccionar a otras rutas
  const redireccionar = useNavigate();

  // Función que se ejecuta al enviar el formulario
  const handleRegistro = async (event) => {
    event.preventDefault(); // Evita que la página se recargue al enviar el formulario
    
    // Imprimir los valores del formulario en consola para depuración
    console.log('Formulario de registro enviado');
    console.log('Nombre:', usuario);
    console.log('Email:', correo);
    console.log('Password:', password);
    console.log('Confirmar Password:', confirmPassword);
     
    // Verificar si las contraseñas coinciden
    if (password !== confirmPassword) {
      alert('Las contraseñas no coinciden'); // Mostrar alerta si son diferentes
      return; // Salir de la función
    }

    try {
      // Hacer una solicitud POST al backend para registrar al usuario
      const peticion = await fetch('http://localhost:8080/Api/Registrar', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json', // Indicar que los datos se envían en formato JSON
        },
        body: JSON.stringify({ usuario, password, correo }), // Enviar los datos del formulario al backend
      });

      // Si el registro fue exitoso
      if (peticion.ok) {
        alert("¡Registrado con éxito!");
        alert("¡Ya puedes iniciar sesión!");
        redireccionar("/"); // Redireccionar a la página de inicio o login
      } else {
        alert('Usuario o clave incorrectos'); // Mostrar mensaje si hubo un error
      }

    } catch (error) {
      // Mostrar error si la solicitud falla
      console.error('Error en la solicitud:', error);
    }
  };

  // Renderizar el formulario de registro
  return (
    <div className="registro-container"> {/* Contenedor principal */}
      
      <h2 id='titulo'>Registro de Usuario</h2> {/* Título del formulario */}
      
      <form onSubmit={handleRegistro} className="formulario"> {/* Formulario con su manejador */}
        <img src={imgSacm} alt="Logo SACM" /> {/* Imagen del logo */}

        {/* Campo de entrada para el nombre de usuario */}
        <div className="form-group">
          <label htmlFor="nombre">Nombre</label>
          <input
            placeholder='Ingrese su nombre'
            type="text"
            id="nombre"
            value={usuario}
            onChange={handleInputChange(setUsuario)}
            required
          />
        </div>

        {/* Campo de entrada para el correo electrónico */}
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            placeholder='Ingrese su email'
            type="email"
            id="email"
            value={correo}
            onChange={handleInputChange(setCorreo)}
            required
          />
        </div>

        {/* Campo de entrada para la contraseña */}
        <div className="form-group">
          <label htmlFor="password">Contraseña</label>
          <input
            placeholder='Genere una contraseña'
            type="password"
            id="password"
            value={password}
            onChange={handleInputChange(setPassword)}
            required
          />
        </div>

        {/* Campo de entrada para confirmar la contraseña */}
        <div className="form-group">
          <label htmlFor="confirmPassword">Confirmar Contraseña</label>
          <input
            placeholder='Confirme su contraseña'
            type="password"
            id="confirmPassword"
            value={confirmPassword}
            onChange={handleInputChange(setConfirmPassword)}
            required
          />
        </div>

        <br />

        {/* Botón para enviar el formulario */}
        <button type="submit" className="btn">Registrarse</button>
      </form>
    </div>
  );
}

// Exportar el componente para usarlo en otras partes de la aplicación
export default Registro;
