package com.javeriana.funkoStore.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author monik
 */
@Entity
public class Reporte {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private Long fecha;
    @Basic
    private double totalVentas;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Venta> ventas;
   

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

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public List<Venta> getVentas() {
        if (ventas == null) {
            ventas = new ArrayList<>();
        }
        return ventas;
    }
    
    public void calcularTotalVentas() {
    	this.totalVentas = 0;
    	for (Venta v : this.ventas) {
    		this.totalVentas += v.getTotalVenta();
    	}
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void addVenta(Venta venta) {
        getVentas().add(venta);
    }

    public void removeVenta(Venta venta) {
        getVentas().remove(venta);
    }

}