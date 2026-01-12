import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Importar componentes
import InicioSesion from '../Auth/Pages/InicioDeSesion.jsx';
import DatosUser from '../User/Pages/DatosUser.jsx';
import CitasPacientes from '../Doctor/Pages/CitasPacientes.jsx';
import DoctoresBd from '../Doctor/Pages/DoctoresBd.jsx';
import HistorialMedico from '../Doctor/Pages/HistorialMedico.jsx';
import SobreNosotros from '../We_Jsx/SobreNosotros.jsx';
import Medicines from '../Doctor/Pages/Medicines.jsx';
import InfoPaciente from '../User/Pages/InfoPaciente.jsx';
import Recover from '../Auth/Pages/RecoverUser/Recover.jsx';
import InsertCodeRecover from '../Auth/Pages/RecoverUser/InsertCodeRecover.jsx';
import ChangePassword from '../Auth/Pages/RecoverUser/ChangePassword.jsx';
import Perfil from '../User/Pages/Perfil.jsx';
import BlogSacm from '../Blog/Pages/BlogSacm.jsx';
import Registro from "../Auth/Pages/Registro.jsx";

/*
PARA QUE EL GESTOR DE RUTAS FUNCIONE DEBEMOS DE UTILIZAR LAS CLASES CON SU INICIAL EN MAYUSCULAS
CUANDO HABLAMOS DE GESTOR DE RUTAS HABLAMOS DE ROUTER QUE SE ENCARGA DE GENERAR LAS RUTAS, DEPENDIENDO
DE LA CLASE A UTILIZAR 
*/
// Componente funcional para manejar las rutas
function App() {
  return (


    <BrowserRouter>
      <Routes>
        {/* Ruta para la página de inicio de sesión */}
        <Route index path="/" element={<InicioSesion />} />

        {/* Ruta para el registro de usuario */}
        <Route path="/datos" element={<DatosUser />} />
        <Route path="/datoscitPacient" element={<CitasPacientes />} />
        {/* Asegúrate de pasar el componente correctamente como JSX */}
        <Route path="/DoctoresBd" element={<DoctoresBd />}/>
        <Route path="/HistoryDoctor" element={<HistorialMedico />}/>
        <Route path="/Nosotros" element={<SobreNosotros />}/> 
        <Route path="/Medicamentos" element={<Medicines />}/> 
        <Route path="/Paciente/:id" element={<InfoPaciente />}/> 
        <Route path="/RecoverPassword" element={<Recover />}/> 
        <Route path="/ChangeCode" element={<ChangePassword />}/> 
        <Route path="/InsertCode" element={<InsertCodeRecover />}/>
        <Route path="/PerfilUser" element ={<Perfil/>}/>
        <Route path='/BlogPerfect' element={<BlogSacm/>} />
        <Route path='/Registro' element={<Registro/>}/>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
