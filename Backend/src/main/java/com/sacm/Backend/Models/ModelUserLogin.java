package com.sacm.Backend.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="userlogin")
public class ModelUserLogin {


@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Getter @Setter @Column(name="id") 
private int id;

@Getter @Setter @Column(name="usuario")  
private String usuario;

@Getter @Setter @Column(name="password") 
private String password;

@Getter @Setter @Column(name="correo") 
private String correo;


    public ModelUserLogin() {
    }

    public ModelUserLogin(int id, String usuario, String password, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

 


}
