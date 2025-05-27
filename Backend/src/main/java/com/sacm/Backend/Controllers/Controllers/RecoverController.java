package com.sacm.Backend.Controllers.Controllers;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.sacm.Backend.Models.ModelUserLogin;


@CrossOrigin(origins = "http://localhost:5173")
@RestController()
@RequestMapping("/Api")
public interface RecoverController extends CrudRepository<ModelUserLogin, Integer>{



//CREACION DE CODIGO DE RECUPERACION 
//AQUI TRATARA DE BUSCAR UNA COINCIDENCIA CON EL CORREO RECIBIDO  POR LA QUERY Y BUSCARLO EN LA BD 
//PERO COMO COMO EL DATO LO ESTAMOS PASANDO ES POR PARAMETRO LA QUERY NO ES NECESARIO UTILIZARLA
@Query("select M from ModelUserLogin M where M.correo like %?1%") 
Optional<ModelUserLogin> findByCorreo( String correo);

}

