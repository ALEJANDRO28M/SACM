import { useState } from "react";
import { useEffect } from "react";
import '../css/stylesRecover/StylesCodeRecover.css';
function InsertCodeRecover({email}){

    const [code,setCode] = useState([]);




    return(
        <div className="main">
          <div className="flexContainerRecover">
            <div className="flexBody">
                <img src="../../public/SACM.png" alt="" id="logoSacm" />
                <h1 id="tittleRecover">Recuperación de la cuenta</h1>
                <p id="textRecover">Para proteger tu cuenta, SACM quiere asegurarse de que realmente seas tú la persona que intenta acceder</p>
            </div>
            <div className="flexBody">
                <form action="submit">
                    <label htmlFor="code">Se envió un correo electrónico con un código de verificación a ale•••••••••••••••@gmail.com</label>
                    <input type="text" id="code" placeholder="Ingresar el codigo" />
                    <button type="submit">Siguiente</button>
                </form>
            </div>
          </div>
        </div>
    )
}

export default InsertCodeRecover;