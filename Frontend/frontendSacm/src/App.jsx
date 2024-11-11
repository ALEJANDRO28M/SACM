import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Importar componentes
import Registro from './DiseñosReactUser/Registro';
import InicioSesion from './DiseñosReactUser/InicioDeSesion';
import DatosUser from './DiseñosReactUser/DatosUser';
import CitasPacientes from './DiseñosReactUser/BasesDeDatosSacm/CitasPacientes';
import Prueba from './DiseñosReactUser/prueba';


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
        <Route path="/prueba" element={<Prueba />}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
