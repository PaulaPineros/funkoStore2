package com.javeriana.funkoStore.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author monik
 */
@Entity
public class Venta {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private Long fecha;
    @Basic
    private double totalVenta;
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    @OneToMany(mappedBy = "venta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        getItems().add(item);
    }

    public void removeItem(Item item) {
        getItems().remove(item);
    }

}