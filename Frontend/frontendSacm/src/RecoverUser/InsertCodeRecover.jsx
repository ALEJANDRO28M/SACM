// Importamos el hook useState para manejar estados en el componente
import { useState } from "react";

// Importamos el hook useEffect para ejecutar efectos secundarios (como llamadas a APIs)
import { useEffect } from "react";

// Importamos el archivo CSS para aplicar estilos al componente
import "../css/stylesRecover/StylesCodeRecover.css";

// Importatmos paquete de Emailjs para poder enviar el codigo de validacion.
import emailjs from '@emailjs/browser';

// Definimos el componente funcional InsertCodeRecover
function InsertCodeRecover() {

  // Declaramos dos estados: uno para el código recibido y otro para el email
  const [code, setCode] = useState("");     // Estado para guardar el código de verificación
  const [email, setEmail] = useState("");   // Estado para guardar el correo electrónico

  

  // // useEffect se ejecuta una sola vez al montar el componente (por el array vacío [])
  // useEffect(() => {

  //         // Guardamos el email en el estado
  //      fetchData();                  // Llamamos a la función para obtener el código (¡OJO! Aquí hay un bug: se usa "email" que aún no se ha actualizado)
  //     // RECUPERAMOS EL EMAIL ENVIADO DE RECOVER 

  // }, []); // Solo ejecuta el efecto una vez al cargar el componente

  // // Función asincrónica para hacer la solicitud al backend y obtener el código de recuperación
  // const fetchData = async () => {

  //   try {
  //       const emailGuardado = localStorage.getItem("email"); // Obtenemos el email guardado en el localStorage
  //       setEmail(emailGuardado)
  //       console.log("Email recibido:", emailGuardado); // Mostramos el email en consola para verificar

  //     const request = await fetch("http://localhost:8080/Api/GeneratedPasswordRecover", {
  //       method: "GET",
  //       headers: {
  //         "Content-Type": "application/json", // Indicamos que se espera JSON
  //       },
  //     });

  //     // Si la solicitud es exitosa
  //     if (request.ok) {
  //       const response = await request.json(); // Convertimos la respuesta en JSON
  //       console.log("codigo ", response.CodigoDeVerificacion); // Mostramos el código en consola
  //       const codigo = response.CodigoDeVerificacion; // Guardamos el código en una variable
  //       setCode(codigo);                            // Guardamos el código en el estado


  //   //    await enviarCorreo(codigo, emailGuardado);          // Llamamos a la función para enviar el correo con el código
        
  //     } else {
  //       alert("datos no cargados"); // Si hubo error en la solicitud
  //     }
  //   } catch (error) {
  //     throw new Error("Error en la solicitud"); // Manejamos cualquier error de red o fetch
  //   }
  // };



  // Lo que se muestra visualmente en la página (HTML/JSX)
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
          <form action="submit" id="formRecover">
            <label htmlFor="code">
              Se envió un correo electrónico con un código de verificación a: <strong>{email}</strong>
            </label>
            <input type="text" id="code" placeholder="Ingresar el código" />
            <div className="btnIcon">
              <button type="submit" id="btn">Siguiente</button>
              <img src="../../public/SACM.png" alt="" id="logoSacm" />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

// Exportamos el componente para poder usarlo en otros archivos
export default InsertCodeRecover;
