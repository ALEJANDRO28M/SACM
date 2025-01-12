package com.sacm.Backend.Models;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="medicos")
public class Doctores {
    
    @Id  
    @Getter @Setter @Column(name="id")
    private int id;

    @Basic
    @Getter @Setter @Column(name="nombre")
    private String nombre;
    @Getter @Setter @Column(name="apellido")
    private String apellido;
    @Getter @Setter @Column(name="especialidad")
    private String especialidad;
    @Getter @Setter @Column(name="telefono")
    private String telefono;
    @Getter @Setter @Column(name="email")
    private String email;


    //RELACIONES ENTRE CLASES-MODELOS
    
    //UN MEDICO PUEDE TENER MUCHAS CITAS CON MUCHOS PACIENTES;
      @OneToMany(cascade= CascadeType.ALL)
      @JoinColumn(name="Medico_id") //El join column genera una nueva fila llamada medico_id en la tabla citas
      private List<Citas> relaOf_Citas;


    //@OneToMany @Getter @Setter @Column(name="HistorialMedico_id")
    //private List<HistorialMedico> historialMedico;

    public Doctores() {
    }

    public Doctores(int id, String nombre, String apellido, String especialidad, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }

}
    
