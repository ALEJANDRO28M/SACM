package com.sacm.Backend.Case.Medicamentos.Infrastructure.persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicamento") @Getter @Setter
public class MedicalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "nombre")
    private String name;

    @Column(name = "Descripcion")
    private String description;

    @Column(name = "dosis")
    private String dose;

    @Column(name = "frecuencia")
    private String frequency;

    public MedicalEntity() {
    }

    public MedicalEntity(Long id, String name, String description, String dose, String frequency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dose = dose;
        this.frequency = frequency;
    }
}
