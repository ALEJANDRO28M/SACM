// Importamos hooks de React
import { useState, useEffect } from "react";

// Importamos el archivo CSS para aplicar estilos al componente
import "../../../../css/Login_Css/StylesRecoverUser_Css/StylesCodeRecover.css";

// Importamos paquete de Emailjs para poder enviar el código de validación
import emailjs from "@emailjs/browser";

// Componente funcional InsertCodeRecover
function InsertCodeRecover() {
  // Estado para guardar el código de verificación
  const [code, setCode] = useState("");

  // Estado para guardar el correo electrónico (si lo necesitas)
  const [email, setEmail] = useState("");

  // Manejo de inputs
  const handleInputChange = (setter) => (event) => {
    setter(event.target.value);
  };

  // Función para validar el código
  const veryCode = async (event) => {
    event.preventDefault();
    try {
      const request = await fetch(
          `http://localhost:8080/Api/keyValidCode?code=${code}`,
          {
            method: "GET",
            headers: { "Content-Type": "application/json" },
          }
      );

      if (request.ok) {
        const response = await request.json();

        if (response.keyValid) {
          alert("VALIDACIÓN EXITOSA, YA PUEDES GENERAR UNA NUEVA CONTRASEÑA!");
          window.location.href = "/ChangeCode";
        } else {
          alert("Código inválido. Intenta de nuevo.");
        }
      } else {
        alert("Error al validar el código.");
      }
    } catch (error) {
      console.error("Error en la solicitud:", error);
      alert("Ocurrió un error al validar el código.");
    }
  };

  return (
      <div className="main">
        <div className="flexContainerRecover">
          <div className="flexBody">
            <h1 id="tittleRecover">Recuperación de la cuenta</h1>
            <p id="textRecover">
              Para proteger tu cuenta, SACM quiere asegurarse de que realmente
              seas tú la persona que intenta acceder
            </p>
          </div>
          <div>
            <form id="formRecover" onSubmit={veryCode}>
              <label htmlFor="code">
                Se envió un correo electrónico con un código de verificación a:{" "}
                <strong>{email || "tu correo registrado"}</strong>
              </label>
              <input
                  className="inputRecover_Insert"
                  type="text"
                  id="code"
                  placeholder="Ingresar el código"
                  value={code}
                  onChange={handleInputChange(setCode)}
                  required
              />
              <div className="btnIcon">
                <button type="submit" id="btn">
                  Siguiente
                </button>
                <img src="/SACM.png" alt="Logo SACM" id="logoSacm" />
              </div>
            </form>
          </div>
        </div>
      </div>
  );
}

// Exportamos el componente
export default InsertCodeRecover;
