package com.javeriana.funkoStore.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * @author monik
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String email;
    @Basic
    @NotNull
    private String password;
    @Basic
    private boolean admin;
    @OneToMany
    private List<Venta> compras;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Venta> getCompras() {
        if (compras == null) {
            compras = new ArrayList<>();
        }
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

    public void addCompra(Venta compra) {
        getCompras().add(compra);
    }

    public void removeCompra(Venta compra) {
        getCompras().remove(compra);
    }

}