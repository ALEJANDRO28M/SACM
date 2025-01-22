import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Importar componentes
import Registro from './DiseñosReactUser/Registro';
import InicioSesion from './DiseñosReactUser/InicioDeSesion';
import DatosUser from './DiseñosReactUser/DatosUser';
import CitasPacientes from './DiseñosReactUser/BasesDeDatosSacm/CitasPacientes';
import Sacm from './DiseñosReactUser/Sacm';
import DoctoresBd from './DiseñosReactUser/BasesDeDatosSacm/DoctoresBd';
import HistorialMedico from './DiseñosReactUser/BasesDeDatosSacm/HistorialMedico';
import SobreNosotros from './DiseñosReactUser/BasesDeDatosSacm/SobreNosotros';
import BasesDeDatos from './DiseñosReactUser/BasesDeDatosSacm/BasesDeDatos';
import Medicines from './DiseñosReactUser/BasesDeDatosSacm/Medicines';

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
        <Route index path="/sesion" element={<InicioSesion />} />

        {/* Ruta para el registro de usuario */}
        <Route path="/registro" element={<Registro />} />

        <Route path="/datos" element={<DatosUser />} />
        <Route path="/datoscitPacient" element={<CitasPacientes />} />
        {/* Asegúrate de pasar el componente correctamente como JSX */}
        <Route path="/Sacm" element={<Sacm />}/>
        <Route path="/DoctoresBd" element={<DoctoresBd />}/>
        <Route path="/HistoryDoctor" element={<HistorialMedico />}/>
        <Route path="/Nosotros" element={<SobreNosotros />}/> 
        <Route path="/BasesDeDatos" element={<BasesDeDatos />}/> 
        <Route path="/Medicamentos" element={<Medicines />}/> 
        
      </Routes>
    </BrowserRouter>
  );
}

export default App;
