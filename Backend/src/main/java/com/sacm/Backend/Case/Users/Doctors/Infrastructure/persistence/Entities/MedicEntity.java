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
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;

    public MedicEntity() {
    }

    public MedicEntity(Long id, String nombre, String apellido, String especialidad, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }
}
