package com.javeriana.funkoStore.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.funkoStore.DTOS.ReporteDTO;
import com.javeriana.funkoStore.DTOS.VentaDTO;
import com.javeriana.funkoStore.entities.Venta;
import com.javeriana.services.IVentaService;
import com.javeriana.funkoStore.entities.Reporte;

@RestController
@RequestMapping("ventas")
public class VentaController {
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping("getVentasFecha/{fecha}/{page}/{size}")
	ReporteDTO getVentasByDate(@RequestParam(name = "fecha", required = false, defaultValue = "20200101")
		@PathVariable int pagina, @PathVariable int size, Long fecha) {
		Iterable <Venta> ventas = ventaService.getVentasFecha(fecha);
		Reporte reporte = new Reporte();
		reporte.setVentas((List<Venta>)ventas);
		reporte.calcularTotalVentas();
		//Transformar a DTO
		ReporteDTO reporteDTO = new ReporteDTO();
		reporteDTO.setFecha(fecha);
		reporteDTO.setTotalVentas(reporte.getTotalVentas());
		reporteDTO.setVentas(reporte.getVentas());
		return reporteDTO;
	}

	@PostMapping
	public VentaDTO post(@RequestBody Venta newVenta) {
		ModelMapper modelMapper = new ModelMapper();
		VentaDTO ventaDTO = modelMapper.map(ventaService.addVenta(newVenta), VentaDTO.class);
		return ventaDTO;
	}

	@DeleteMapping
	public String deleteAll() {
		ventaService.deleteAllVentas();
		return "Todas las ventas han sido eliminadas";
	}

	@DeleteMapping("/eliminar/{id}")
	public String deleteVenta(@PathVariable Long id) {
		ventaService.deleteVenta(id);
		return "Venta eliminada exitosamente";
	}

}
