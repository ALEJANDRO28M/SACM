package com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities;

import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import com.sacm.Backend.Case.Users.Doctors.Infrastructure.persistence.Entities.MedicEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "userlogin")
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
    @JoinColumn(name = "role_id")
    RoleEntity role;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    MedicEntity doctor;

}
