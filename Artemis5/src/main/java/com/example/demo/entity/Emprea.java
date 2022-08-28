package com.example.demo.entity;

import jdk.jfr.Name;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity
public class Empresa {

    @Id
    private long nit;  //nit
    @unique
    private String nombre;
    @unique
    private String document;

    private String telefono;

    private String direccion;

    private User[] usuarios;

    private MovimientoDinero[] transacciones;

    private Date createdAt;

    private Date updateAt;

    @OneToMany
    private Empleado empleado;


    public Empresa(long nit,String nombre,String document,String telefono,String direccion,User[] userios, Transaction[] transacciones, Date createdAt, Date updateAt, Empleado empleado ){
        this.nit = nit;
        this.nombre = nombre;
        this.document = document;
        this.telfono = telefono;
        this.direccion = direccion;
        this.users = users;
        this.transacciones = transacciones;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.empleado = empleado;

    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public User[] getUsers() {
        return usuarios;
    }

    public void setUsuarios(User[] usuarios) {
        this.usuarios = usuarios;
    }

    public MovimientoDinero[] getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(MovimientoDinero[] transacciones) {
        this.transacciones = transacciones;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}



