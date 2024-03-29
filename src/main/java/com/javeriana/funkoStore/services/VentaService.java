package com.javeriana.funkoStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.funkoStore.entities.Venta;
import com.javeriana.funkoStore.repositories.VentaRepository;

@Service
public class VentaService implements IVentaService{
	@Autowired
	VentaRepository ventaRepository;

	@Override
	public Venta addVenta(Venta newVenta) {
		return ventaRepository.save(newVenta);
	}
	
	@Override
	public void deleteVenta(Long id) {
		java.util.Optional<Venta> v = ventaRepository.findById(id);
		if(v != null){
			ventaRepository.deleteById(id);
		}
	}
	
	@Override
	public void deleteAllVentas() {
		ventaRepository.deleteAll();
	}
	
	@Override
	public Iterable<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}
	
	@Override
	public Iterable<Venta> getVentasFecha(Long fecha) {
		return ventaRepository.findByDate(fecha);
	}

}
