import { useState } from "react";
import "../../../../css/Login_Css/StylesRecoverUser_Css/NewCodeStyles.css" // Asegúrate de tener este archivo CSS


// Componente funcional ChangePassword
function ChangePassword() {
  // Definimos dos estados: uno para la nueva contraseña y otro para confirmarla
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

   //MANEJAMOS EL ESTADO DE LOS INPUTS CON EL USESTATE UTILIZANDO LA SIGUIENTE FUNCION
   const handleInputChange = (setter) => (event) => {
    setter(event.target.value);
  };


  // Función que se ejecuta cuando el usuario envía el formulario
  const handleSubmit = (e) => {
    e.preventDefault(); // Evita que se recargue la página al enviar

    // Validamos si la contraseña tiene menos de 8 caracteres
    if (password.length < 8) {
      alert("La contraseña debe tener al menos 8 caracteres.");
      return; // Salimos de la función si no cumple la condición
    }

    // Validamos si las contraseñas no coinciden
    if (password !== confirmPassword) {
      alert("Las contraseñas no coinciden.");
      return;
    }

    // Si todo está bien, mostramos mensaje de éxito
    alert("¡Contraseña actualizada correctamente!");
    // Aquí puedes enviar la contraseña al backend si lo deseas

   
  };
   const updatePassword = async (event) =>{
     event.preventDefault();

     try {
        const request = await fetch(`http://localhost:8080/Api/UpdatePasswordLogin?password=${password}`,{
            method:"POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(
                {newPassword: password}
            )
        });
        if(request.ok){
          alert("TODO HA SALIDO CORRECTAMENTE")
        }
        
     } catch (error) {
        
     }
    }

  // Retornamos el JSX del formulario
  return (
    <div className="mainNewPassword">
      <div className="formContainer">
        <h2>Crear nueva contraseña</h2>
        <p>Ingresa tu nueva contraseña y confírmala para continuar.</p>
        
        <form action="submit    " onSubmit={updatePassword}>
          {/* Campo de entrada para la nueva contraseña */}
          <input
            type="password"
            placeholder="Nueva contraseña"
            value={password}
            onChange={handleInputChange(setPassword)} // Actualiza el estado
            required
          />

          {/* Campo de entrada para confirmar la nueva contraseña */}
          <input
            type="password"
            placeholder="Confirmar contraseña"
            value={confirmPassword}
            onChange={handleInputChange(setConfirmPassword)} // Actualiza el estado
            required
          />

          {/* Botón para enviar el formulario */}
          <button type="submit">Actualizar contraseña</button>
        </form>
      </div>
    </div>
  );
}

// Exportamos el componente para poder usarlo en otros archivos
export default ChangePassword;  