package com.sacm.Backend.Case.Citas.Infrastructure.persistence.Entities;

import com.sacm.Backend.Case.Users.Users_Patients.Infrastructure.persistence.Entities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "citaspacientes") @Getter @Setter
public class CitasEntitys {

    @Id
    @Column(name="id")
    private long id;


    @Temporal(TemporalType.DATE) @Getter @Setter @Column(name="fecha")
    private String fecha;


    @Basic @Column(name="motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private UserEntity user;



    public CitasEntitys() {
    }

    public CitasEntitys(long id, String fecha, String motivo, UserEntity user) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.user = user;
    }


}
