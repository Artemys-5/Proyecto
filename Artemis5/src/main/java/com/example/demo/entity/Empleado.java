package com.example.demo.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nombre;

    @Column(name = "email", unique = true)
    private String email;

    private Profile profile;
    @ManyToOne
    private Empresa empresa;

    private Enum_RoleName rol ;

    private MovimientoDinero[] transacciones;
    private Date updateAt;
    private Date createdAt;

    public EMpleado (String nombre, String email, Profile profile ,Empresa empresa, Enum_RoleName rol, MovimientoDinero[] transacciones , Date updateAt, Date createdAt) {
        this.nombre = nombre;
        this.email = email;
        this.profile = profile;
        this.empresa = empresa;
        this.rol = rol;
        this.transacciones = transacciones;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Empresa getEmpresa() {

        return Empresa;
    }

    public void setEmpresa(Empresa empresa) {

        this.empresa = empresa;
    }

    public Date getUpdateAt() {

        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {

        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {

        this.createdAt = createdAt;
    }
}

