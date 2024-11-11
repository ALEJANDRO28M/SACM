package com.sacm.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="userlogin")
public class ModelUserLogin {

@Id @Getter @Setter @Column(name="id") 
private int id;

@Getter @Setter @Column(name="usuario")  
private String usuario;

@Getter @Setter @Column(name="password") 
private String password;


    public ModelUserLogin() {
    }

    public ModelUserLogin(int id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }




}
