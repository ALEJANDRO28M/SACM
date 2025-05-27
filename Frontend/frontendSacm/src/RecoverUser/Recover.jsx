import { useState } from "react";
import { useEffect } from "react";
import "../css/stylesRecover/stylesRecover.css";
import InsertCodeRecover from "./InsertCodeRecover";
function Recover() {
  const [codeEncrypt, setCodeEncrypt] = useState("");
  const [email, setEmail] = useState("");

  const handleInputChange = (setter) => (event) =>{
    setter(event.target.value);
  }

  const generateCode = async (event) => {
    event.preventDefault();
    try {
      const respuesta = await fetch(
        `http://localhost:8080/Api/ValidCode?correo=${email}`,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
            },
        }
      );
      const dataCode = await respuesta.json();
      setCodeEncrypt(dataCode); // guarda la respuesta en el estado
       console.log(codeEncrypt)
       InsertCodeRecover(codeEncrypt);
    } catch (error) {
     
      console.error("Error al llamar la API:", error);
    }
  };

  return (
    <div className="recover">
      <div className="forgot-container">
        <h2 className="textDescript">¿Olvidaste tu contraseña?</h2>
        <p id="textRecover">
          Ingresa tu correo electrónico para enviarte un enlace de recuperación.
        </p>
        <form id="forgot-form" onSubmit={generateCode}>
          <input
            type="email"
            id="email"
            value={email}
            onChange={handleInputChange(setEmail)}
            placeholder="Correo electrónico"
            required
          />
          <button type="submit">Enviar enlace</button>
        </form>
      </div>
    </div>
  );
}
export default Recover;
