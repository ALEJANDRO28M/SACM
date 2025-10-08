package com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities;

import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userlogin") @Getter @Setter
public class UserLoginEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "usuario")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "correo")
    private String email;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    MedicEntity doctor;


    public UserLoginEntity() {
    }

    public UserLoginEntity(Long id, String user, String password, String email,MedicEntity doctor) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.email = email;
        this.doctor = doctor;
    }
}
