// Importar el hook useState de React para manejar el estado local del componente
import { useState } from "react";

// Importar los estilos personalizados para el componente de registro
import "../css/Registros.css";

// Importar la función useNavigate del enrutador para redireccionar después del registro
import { useNavigate } from "react-router-dom";

// Importar la imagen del logo SACM
import imgSacm from "../css/SACM.png";

//Importacion de mui material parwa un mejor diseño y estructura de
//de los formularios
import {Alert,Select,MenuItem} from "@mui/material";

//Importacion de react form y yup
import {useForm} from "react-hook-form";
import { yupResolver } from '@hookform/resolvers/yup';


//Importamos clase js yup para que se comunique con form
import { registroSchema } from "../Utils/ValidationSchema.js";

// Definición del componente funcional Registro
function Registro() {
  // Estados para manejar los valores del formulario
  const [usuario, setUsuario] = useState(""); // Estado para el nombre de usuario
  const [correo, setCorreo] = useState(""); // Estado para el correo electrónico
  const [password, setPassword] = useState(""); // Estado para la contraseña
  const [confirmPassword, setConfirmPassword] = useState(""); // Estado para confirmar la contraseña
  const [role,setRole] = useState("");
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
    console.log("Formulario de registro enviado");
    console.log("Nombre:", usuario);
    console.log("Email:", correo);
    console.log("Password:", password);
    console.log("Confirmar Password:", confirmPassword);
    console.log("Role:",role);

    // Verificar si las contraseñas coinciden
    if (password !== confirmPassword) {
      alert("Las contraseñas no coinciden"); // Mostrar alerta si son diferentes
      return; // Salir de la función
    }

    try {
      // Hacer una solicitud POST al backend para registrar al usuario
      const peticion = await fetch("http://localhost:8080/Api/CreateUserLogin", {
        method: "POST",
        headers: {
          "Content-Type": "application/json", // Indicar que los datos se envían en formato JSON
        },

        body: JSON.stringify({ usuario, password, correo, role }), // Enviar los datos del formulario al backend
      });

      // Si el registro fue exitoso
      if (peticion.ok) {
        alert("¡Registrado con éxito!");
        alert("¡Ya puedes iniciar sesión!");
        redireccionar("/"); // Redireccionar a la página de inicio o login
      } else {
        alert("Usuario o clave incorrectos"); // Mostrar mensaje si hubo un error
      }
    } catch (error) {
      // Mostrar error si la solicitud falla
      console.error("Error en la solicitud:", error);
    }
  };

  const {register,handleSubmit,formState : {errors}} = useForm(
      { resolver: yupResolver(registroSchema)},
  );

  // Renderizar el formulario de registro
  return (
    <div className="mainRegister">
      <div className="registro-container">
      {" "}
         <h2 id="titulo">Registro de Usuario</h2> {/* Título del formulario */}
      {/* Contenedor principal */}
      <div className="contForm">
      <img src={imgSacm} alt="Logo SACM" className="imgRegisterSacm"/> {/* Imagen del logo */}
      <form onSubmit={handleSubmit(handleRegistro)} className="formulario">
        {" "}
        {/* Formulario con su manejador */}

        {/* Campo de entrada para el nombre de usuario */}
        <div className="form-group">
          <label htmlFor="nombre">Nombre</label>
          <input
              {...register("name")}
            className="inputsRegister"
            placeholder="Ingrese su nombre"
            type="text"
            id="nombre"
              onChange={handleInputChange(setUsuario)}
          />
          {errors.name && (
              <Alert severity="error"
              sx={{
                marginTop:"05px",
                paddingTop:"0",
                paddingBottom:"0",
                borderRadius:"20px",
              }}
              >
                {errors.name.message}
              </Alert>
          )}
        </div>
        {/* Campo de entrada para el correo electrónico */}
        <div className="form-group">
          <label htmlFor="emailRegister">Email</label>
          <input
              {...register("email")}
            className="inputsRegister"
            placeholder="Ingrese su email"
            type="emailRegister"
            id="emailRegister"
            onChange={handleInputChange(setCorreo)}
            required
          />
          {errors.email && (
              <Alert severity="error"
                     sx={{
                       marginTop:"05px",
                       paddingTop:"0",
                       paddingBottom:"0",
                       borderRadius:"20px",
                     }}
              >
                {errors.email.message}
              </Alert>
          )}
        </div>
        {/* Campo de entrada para la contraseña */}
        <div className="form-group">
          <label htmlFor="password">Contraseña</label>
          <input
              {...register("password")}
            className="inputsRegister"
            placeholder="Genere una contraseña"
            type="password"
            id="password"
            onChange={handleInputChange(setPassword)}
            required
          />
          {errors.password && (
              <Alert severity="error"
                     sx={{
                       marginTop:"05px",
                       paddingTop:"0",
                       paddingBottom:"0",
                       borderRadius:"20px",
                     }}
              >
                {errors.password.message}
              </Alert>
          )}
        </div>
        {/* Campo de entrada para confirmar la contraseña */}
        <div className="form-group">
          <label htmlFor="confirmPassword">Confirmar Contraseña</label>
          <input
              {...register("confirmPassword")}
            className="inputsRegister"
            placeholder="Confirme su contraseña"
            type="password"
            id="confirmPassword"
            onChange={handleInputChange(setConfirmPassword)}
            required
          />
          {errors.confirmPassword && (
              <Alert severity="error"
                     sx={{
                       marginTop:"05px",
                       paddingTop:"0",
                       paddingBottom:"0",
                       borderRadius:"20px",
                     }}
              >
                {errors.confirmPassword.message}
              </Alert>
          )}
        </div>
        {/* Display Empty acturara como un placeholder pero en el select,
        con la finalidad de que podamos incorporar una propiedad vacia
        pero que contiene la etiqueta texto como tal*/}
        <br />
        <label style={{marginBottom:"0px"}} >Seleccione un Role</label>
        <Select
            {...register("role")}
            onChange={(e) => setRole(e.target.value) }
            displayEmpty size="small"
        >
          <MenuItem >
            -
          </MenuItem>
          <MenuItem value="admin" >Admin</MenuItem>
          <MenuItem value="user">User</MenuItem>
        </Select>
        {errors.role &&(
            <Alert severity="error"
                   sx={{
                     marginTop:"0px",
                     paddingTop:"0",
                     paddingBottom:"0",
                     borderRadius:"20px",
                   }}
            >{errors.role.message}</Alert>
        )}
        <br />
        {/* Botón para enviar el formulario */}
        <button type="submit" className="btn">
          Registrarse
        </button>
      </form>
      </div>
      </div>
    </div>
  );
}

// Exportar el componente para usarlo en otras partes de la aplicación
export default Registro;
