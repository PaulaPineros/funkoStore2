package com.javeriana.funkoStore.controllers;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javeriana.funkoStore.DTOS.ProductoDTO;
import com.javeriana.funkoStore.entities.Producto;
import com.javeriana.services.ProductoService;

public class ProductoController {
	@Autowired
	private ProductoService productoService;
/*
	@GetMapping("getProductos/{page}/{size}")
	Page<ProductoDTO> getAllProductos(@PathVariable int page, @PathVariable int size) {
		return transformarDTO(productoService.getAllProdcuts(PageRequest.of(page, size)));
	}*/

	@PutMapping("actualizar/{id}")
	public ProductoDTO actualizarProducto(@RequestBody Producto newProducto, @PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();
		ProductoDTO productoDTO = modelMapper.map(productoService.updateProducto(newProducto, id),
				ProductoDTO.class);
		return productoDTO;
	}

	@PostMapping
	public ProductoDTO post(@RequestBody Producto newProducto) {
		ModelMapper modelMapper = new ModelMapper();
		ProductoDTO productoDTO = modelMapper.map(productoService.addProducto(newProducto), ProductoDTO.class);
		return productoDTO;
	}

	@DeleteMapping
	public String deleteALL() {
		productoService.deleteAllProducts();
		return "Respuesta desde el metodo DELETE";
	}

	@DeleteMapping("/eliminar/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productoService.deleteProduct(id);
		return "Producto eliminado correctamente";
	}

	/*public Page<ProductoDTO> transformarDTO(Page<Producto> productos) {
		List<ProductoDTO> productosList = new ArrayList<>();
		for (Producto p : productos) {
			ProductoDTO pDTO = new ProductoDTO();
			pDTO.setId(p.getId());
			pDTO.setNombre(p.getNombre());
			pDTO.setPrecio(p.getPrecio());
			pDTO.setImagen(p.getImagen());
			pDTO.setDescripcion(p.getDescripcion());	
			productosList.add(pDTO);
		}
		Page<ProductoDTO> productosDTO = new PageImpl<>(productosList);
		return productosDTO;
	}*/

}
