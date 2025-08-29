package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities;


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


    public CitasEntitys() {
    }

    public CitasEntitys(long id, String fecha, String motivo) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;

    }


}
