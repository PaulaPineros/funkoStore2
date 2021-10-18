package com.javeriana.funkoStore.services;

import com.javeriana.funkoStore.entities.Venta;

public interface IVentaService {
	Venta addVenta(Venta newVenta);
	void deleteVenta(Long id);
	void deleteAllVentas();
	Iterable<Venta> getAllVentas();
	Iterable<Venta> getVentasFecha(Long fecha);
}
