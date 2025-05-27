package com.sacm.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="recovercode")
public class ModelCode {

    @Id
    private int id;

    @Column(name="code")
    private String code;

    public ModelCode() {
    }

    public ModelCode(int id, String code) {
        this.id = id;
        this.code = code;
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

    

}
