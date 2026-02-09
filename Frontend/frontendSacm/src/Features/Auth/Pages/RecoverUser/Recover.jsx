// ======================================
// 📦 IMPORTACIONES
// ======================================
import { useState, useEffect } from "react";
import "../../../../css/Login_Css/StylesRecoverUser_Css/stylesRecover.css";
import emailjs from '@emailjs/browser';
import { useNavigate } from "react-router-dom";

// ======================================
// 🔐 COMPONENTE RECOVER
// ======================================
function Recover() {

  const redirect = useNavigate();

  // Inicializar EmailJS al montar el componente
  useEffect(() => {
    emailjs.init("xNHKp-0V8wjqTWh_E");
  }, []);

  // ======================================
  // 🔧 ESTADOS LOCALES
  // ======================================
  const [codeEncrypt, setCodeEncrypt] = useState("");
  const [email, setEmail] = useState("");

  // ======================================
  // ✍️ MANEJADOR DE INPUTS
  // ======================================
  const handleInputChange = (setter) => (event) => {
    setter(event.target.value);
  };

  // ======================================
  // 🔄 FUNCIÓN PRINCIPAL DE CONTROL
  // ======================================
  const controllerFunction = async (event) => {
    event.preventDefault();

    // Validar si el correo es válido
    await validEmail();

    // Generar código y enviarlo
    let codigoGenerado = ""; // variable local para evitar problemas de asincronía

    try {
      const res = await fetch("http://localhost:8080/Api/GeneratedPasswordRecover", {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });

      if (res.ok) {
        const data = await res.json();
        codigoGenerado = data.reCode;
        setCodeEncrypt(codigoGenerado); // (opcional) actualiza estado si se requiere más adelante
        console.log("Código generado:", codigoGenerado);
      } else {
        alert("No se pudo generar el código.");
        return;
      }
    } catch (error) {
      console.error("Error al generar el código:", error);
      return;
    }

    // Enviar correo con el código generado
    await enviarCorreo(codigoGenerado, email);

    // Guardar correo en localStorage
    localStorage.setItem("email", email);

    alert('Enviando Código...');
    redirect('/InsertCode');
  };

  // ======================================
  // 🔍 VALIDACIÓN DE EMAIL
  // ======================================
  const validEmail = async () => {
    try {
      const res = await fetch(`http://localhost:8080/Api/ValidCode?correo=${email}`, {
        method: "GET",
        headers: { "Content-Type": "application/json" },
      });

      if (res.ok) {
        const response = await res.json();
        console.log("Email verificado:", response);
      }
    } catch (error) {
      console.error("Error al llamar la API:", error);
    }
  };

  // ======================================
  // ✉️ ENVÍO DEL CORREO
  // ======================================
  const enviarCorreo = async (code, email) => {
    const serviceID = 'default_service';
    const templateID = 'template_d6pt6bw';

    const templateParams = {
      reCode: code,
      reEmail: email,
    };

    emailjs.send(serviceID, templateID, templateParams)
      .then(() => {
        alert('Correo enviado con éxito');
      })
      .catch((error) => {
        alert('Error al enviar: ' + error.text);
      });
  };

  // ======================================
  // 🧾 INTERFAZ DEL COMPONENTE
  // ======================================
  return (
    <div className="recover">
      <div className="forgot-container">
        <h2 className="textDescript">¿Olvidaste tu Usuario y/o Contrasenia?</h2>
        <p id="textRecover">
          Ingresa tu correo electrónico para enviarte un enlace de recuperación.
        </p>
        <form id="forgot-form" onSubmit={controllerFunction}>
          <input
            type="email"
            id="reEmail"
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

// ======================================
// 🚀 EXPORTACIÓN DEL COMPONENTE
// ======================================
export default Recover;


// // ❌ POR QUÉ EL CÓDIGO ORIGINAL FALLABA:

// // 1. El valor del código generado se guardaba en el estado: setCodeEncrypt(data.reCode);
// //    Pero inmediatamente después querías usarlo con enviarCorreo(JSON.stringify(codeEncrypt), email);

// // 2. El problema es que setCodeEncrypt es ASÍNCRONO.
// //    Eso significa que NO actualiza 'codeEncrypt' inmediatamente.

// //    Entonces, en tiempo real, esta línea usaba un valor desactualizado:
// //    await enviarCorreo(JSON.stringify(codeEncrypt), email);
// //    -> codeEncrypt todavía estaba vacío ("") cuando se ejecutaba esta línea.

// // 🔧 EJEMPLO SIMPLIFICADO DEL ERROR:
// setCodeEncrypt("1234");
// console.log(codeEncrypt); // ⛔ Sigue imprimiendo "", porque el estado aún no se ha actualizado.


// // ✅ POR QUÉ EL NUEVO CÓDIGO FUNCIONA:

// // En lugar de depender de setCodeEncrypt (que es lento porque React necesita renderizar),
// // usamos una variable local llamada 'codigoGenerado', así:
// let codigoGenerado = data.reCode;

// // Esta variable existe en el contexto de la función async y está disponible de inmediato,
// // así que al pasarla a emailjs.send, el valor es correcto:
// await enviarCorreo(codigoGenerado, email); // ✅ Aquí sí tiene el valor correcto ("1234")

// // No es necesario esperar a que React actualice el estado.
// // Esto evita errores de sincronización.


// // ✅ CONCLUSIÓN:
// // No necesitas clases ni estructuras complejas.
// // Solo evita usar el estado (`useState`) para datos que necesitas *de inmediato* después de obtenerlos.
// // En esos casos, usa una variable local como hicimos con 'codigoGenerado'