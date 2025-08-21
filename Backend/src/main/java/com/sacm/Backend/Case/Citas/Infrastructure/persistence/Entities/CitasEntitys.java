package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sacm.Backend.Models.HistorialMedico;
import com.sacm.Backend.Models.User_Of_Patients;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "citaspacientes")
public class CitasEntitys {

    @Id
    @Getter
    @Setter
    @Column(name="id")
    private long id;


    @Temporal(TemporalType.DATE) @Getter @Setter @Column(name="fecha")
    private String fecha;


    @Basic @Getter @Setter @Column(name="motivo")
    private String motivo;

    //RELACIONES ENTRE CLASES O MODELS
    @ManyToOne
    @JoinColumn(name="Historial_id")
    @Getter @Setter
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
    @Getter @Setter
    private User_Of_Patients user_Of_Patients;

    public CitasEntitys() {
    }

    public CitasEntitys(int id, String fecha, String motivo, HistorialMedico historialMedico,
                        User_Of_Patients user_Of_Patients) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.historialMedico = historialMedico;
        this.user_Of_Patients = user_Of_Patients;
    }


}
