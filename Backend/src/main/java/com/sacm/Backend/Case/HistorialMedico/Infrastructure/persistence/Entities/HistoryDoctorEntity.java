package com.sacm.Backend.Case.HistorialMedico.Infrastructure.persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "historialesmedicos")
public class HistoryDoctorEntity {

    @Id
    @Getter
    @Setter
    @Column(name="id")
    private int id;


    @Temporal(TemporalType.DATE)
    @Getter @Setter @Column(name="fecha")
    private String fecha;


    @Basic @Getter @Setter @Column(name="diagnostico")
    private String diagnostico;


    @Basic @Getter @Setter @Column(name="tratamiento")
    private String tratamiento;


    //RELACIONES ENTRE CLASES-MODELOS
    //@OneToMany @Getter @Setter @Column(name="Citas_id")
    //private List<Citas> citas;

    //@ManyToOne @Getter @Setter @Column(name="Doctor_id")
    //private Doctores doctor;


    public HistoryDoctorEntity() {
    }

    public HistoryDoctorEntity(int id, String fecha, String diagnostico, String tratamiento/*List<Citas> citas, Doctores doctor*/ ) {
        this.id = id;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        // this.citas = citas;
        // this.doctor = doctor;
    }


}
