package com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicos") @Getter @Setter
public class MedicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;

    public MedicEntity() {
    }

    public MedicEntity(
            Long id, String nombre,
            String apellido, int edad,
            String especialidad, String telefono,
            String email, String description )
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.description = description;
    }
}
