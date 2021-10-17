package com.javeriana.services;

import com.javeriana.funkoStore.entities.Venta;

public interface IVentaService {
	Venta addVenta(Venta newVenta);
	void deleteProduct(Long id);
	void deleteAllVentas();
	Iterable<Venta> getAllVentas();
}
