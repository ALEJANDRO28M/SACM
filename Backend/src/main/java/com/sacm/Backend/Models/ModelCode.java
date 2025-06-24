package com.sacm.Backend.Models;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="recovercode")
public class ModelCode {

    @Id
    private int id;

    @Column(name="code")
    private String code;

    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpiracion;

    public ModelCode() {
    }


    public ModelCode(int id, String code, Date fechaExpiracion) {
        this.id = id;
        this.code = code;
        this.fechaExpiracion = fechaExpiracion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }


public void setFechaExpiracion(Date fechaExpiracion) {
    this.fechaExpiracion = fechaExpiracion;
}


    

    

}
