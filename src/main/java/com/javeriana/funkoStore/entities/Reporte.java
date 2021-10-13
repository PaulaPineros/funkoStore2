package com.javeriana.funkoStore.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
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
    private Date fecha;
    @Basic
    private double totalVentas;
    @OneToMany
    private List<Venta> ventas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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