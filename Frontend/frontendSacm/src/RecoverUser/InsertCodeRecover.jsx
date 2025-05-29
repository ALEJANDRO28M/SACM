import { useState } from "react";
import { useEffect } from "react";
import '../css/stylesRecover/StylesCodeRecover.css';
function InsertCodeRecover(){

    const [code,setCode] = useState("");


    useEffect(() => {
        fetchData(); // Llamar a la función al montar el componente
    }, []); // Solo ejecuta el efecto una vez al cargar

    const fetchData = async () =>{
        try {
            const request = await fetch('http://localhost:8080/Api/GeneratedPasswordRecover',{
                method : 'GET',
                 headers: {
                    'Content-Type': 'application/json',
                },
            })
            if (request.ok) {
                    const response = await request.json();
                     console.log("codigo ", response.CodigoDeVerificacion);
                    setCode(response);
                   
            }else{
                alert("datos no cargados")
            }

        } catch (error) {
              throw new Error('Error en la solicitud');
        };

    }

    return(
        <div className="main">
          <div className="flexContainerRecover">
            <div className="flexBody">
                
                <h1 id="tittleRecover"  >Recuperación de la cuenta</h1>
                <p id="textRecover" >Para proteger tu cuenta, SACM quiere asegurarse de que realmente seas tú la persona que intenta acceder</p>
            </div>
            <div >
                <form action="submit" id="formRecover">
                    <label htmlFor="code" >Se envió un correo electrónico con un código de verificación a ale•••••••••••••••@gmail.com</label>
                    <input  type="text" id="code" placeholder="Ingresar el codigo" />
                    <div className="btnIcon">
                    <button type="submit" id="btn">Siguiente</button>
                    <img src="../../public/SACM.png" alt="" id="logoSacm"  />
                    </div>
                </form>
            </div>
          </div>
        </div>
    )
}

export default InsertCodeRecover;