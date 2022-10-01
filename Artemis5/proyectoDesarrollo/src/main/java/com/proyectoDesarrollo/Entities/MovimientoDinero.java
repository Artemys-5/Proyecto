package com.proyectoDesarrollo.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "movimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "monto")
    private float monto;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // clave al momento de visualizar
    private Usuario user;

    //Las dos lineas de abajo, funcionaban segun el video
    //    @ManyToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "empresa_id", referenceColumnName = "id")
    //@OneToMany(mappedBy = "transaccion")
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // clave al momento de visualizar
    private Empresa empresa;

    public MovimientoDinero(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario usuario) {
        this.user = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
