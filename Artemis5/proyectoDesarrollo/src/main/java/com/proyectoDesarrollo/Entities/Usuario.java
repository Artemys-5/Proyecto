package com.proyectoDesarrollo.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;
    @Column(name="email", unique = true)
    private String email;
    @Column(name = "rol")
    //private String rol;
    private Enum_RoleName rol;

    @Column(name = "password")
    //private String rol;
    private String password;
    @OneToOne
    @JoinColumn(name = "perfilUser")
    private PerfilUsuario perfil;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MovimientoDinero> transacciones = new HashSet<>(); //en forma de array

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empresa enterprise;

    //private Empresa enterprise;


    //@OneToMany
    //@JoinColumn(name = "empresa")
    //@ManyToOne
    //@JoinColumn(name = "transaccion")
    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public Enum_RoleName getRol() {
        return rol;
    }


    public void setRol(Enum_RoleName rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Empresa getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Empresa empresa) {
        this.enterprise = enterprise;
    }

    public Set<MovimientoDinero> getTransaccion() {
        return transacciones;
    }

    public void setTransaccion(Set<MovimientoDinero> transaccion) {
        this.transacciones = transaccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
