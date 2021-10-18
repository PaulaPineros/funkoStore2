package com.javeriana.funkoStore.DTOS;

import java.util.ArrayList;
import java.util.List;

import com.javeriana.funkoStore.entities.Venta;

public class ReporteDTO {

	private Long id;
    private Long fecha;
    private double totalVentas;
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

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

}

