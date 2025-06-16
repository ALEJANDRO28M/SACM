package com.sacm.Backend.Controllers.Controllers;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacm.Backend.Models.ModelCode;
import java.util.List;




@CrossOrigin(origins = "http://localhost:5173")
@RestController()
@RequestMapping("/Api")
public interface codeVeryController extends CrudRepository<ModelCode, Integer>{


    //ESTE CODIGO BUSCARA UN DATO EXACTO EN LA BASE DE DATOS EN ESTE CASO
    //BUSCARA EL CODIGO RECIBIDO POR PARAMETRO Y DEVOLVERA UN OPTIONAL DONDE PUEDE SER UN TRUE
    //O UN FALSE 
    @Query("SELECT C FROM ModelCode C WHERE C.code = ?1 ")
    Optional<ModelCode>findByCode(String code);
    




}
