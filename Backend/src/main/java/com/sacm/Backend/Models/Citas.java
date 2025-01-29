package com.sacm.Backend.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="citaspacientes") 
public class Citas {

    @Id @Getter @Setter
     @Column(name="id")
    private int id;


    @Temporal(TemporalType.DATE) @Getter @Setter @Column(name="fecha")
    private String fecha;


    @Basic @Getter @Setter @Column(name="motivo")
    private String motivo;

    //RELACIONES ENTRE CLASES O MODELS 
    @ManyToOne
    @JoinColumn(name="Historial_id")
    private HistorialMedico historialMedico;



    //MANY TO ONE- MUCHAS CITAS PUEDE TENER UN DOCTOR 
    //@ManyToOne @Getter @Setter @Column(name="Doctor_id")
    //private Doctores doctor;


    //ONE TO MANY- UNA CITA PUEDE TENER MUCHAS PRESCRIPCIONES 
    //@OneToMany @Getter @Setter @Column(name="Prescripciones_id")
    //private List<Prescripciones> prescripciones;

    @OneToOne 
    @JoinColumn(name = "Paciente_id")   
    @JsonManagedReference // Esto maneja la relación en un solo lado
    private User_Of_Patients user_Of_Patients;

    public Citas() {
    }

    public Citas(int id, String fecha, String motivo, HistorialMedico historialMedico,
            User_Of_Patients user_Of_Patients) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.historialMedico = historialMedico;
        this.user_Of_Patients = user_Of_Patients;
    }



}

