package com.sacm.Backend.Case.Login.Infrastructure.persistence.Entities;

import com.sacm.Backend.Case.Login.Infrastructure.persistence.Repositories.SpringDataLogin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userlogin") @Getter @Setter
public class UserLoginEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    @Column(name = "usuario")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "correo")
    private String email;

    public UserLoginEntity() {
    }

    public UserLoginEntity(Long id, String user, String password, String email) {
        Id = id;
        this.user = user;
        this.password = password;
        this.email = email;
    }
}
