import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Importar componentes
import Registro from './DiseñosReactUser/Registro';
import InicioSesion from './DiseñosReactUser/InicioDeSesion';
import DatosUser from './DiseñosReactUser/DatosUser';
import CitasPacientes from './DiseñosReactUser/BasesDeDatosSacm/CitasPacientes';
import DoctoresBd from './DiseñosReactUser/BasesDeDatosSacm/DoctoresBd';
import HistorialMedico from './DiseñosReactUser/BasesDeDatosSacm/HistorialMedico';
import SobreNosotros from './DiseñosReactUser/BasesDeDatosSacm/SobreNosotros';  
import Medicines from './DiseñosReactUser/BasesDeDatosSacm/Medicines';
import InfoPaciente from './DiseñosReactUser/BasesDeDatosSacm/InfoPaciente';
import Recover from './RecoverUser/Recover';
import InsertCodeRecover from './RecoverUser/InsertCodeRecover';
import ChangePassword from './RecoverUser/changePassword';
import Perfil from './DiseñosReactUser/Perfil';
import BlogSacm from './DiseñosReactUser/BlogSacm';

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
        <Route path="/registro" element={<Registro />} />
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
      </Routes>
    </BrowserRouter>

  );
}

export default App;
