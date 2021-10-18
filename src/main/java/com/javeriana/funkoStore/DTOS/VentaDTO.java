package com.javeriana.funkoStore.DTOS;

import java.util.ArrayList;
import java.util.List;
import com.javeriana.funkoStore.entities.Item;
import com.javeriana.funkoStore.entities.Usuario;

public class VentaDTO {
	
    private Long id;
    private Long fecha;
    private double totalVenta;
    private Usuario usuario;
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
