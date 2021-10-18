package com.javeriana.funkoStore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.funkoStore.DTOS.ProductoDTO;
import com.javeriana.funkoStore.entities.Producto;
import com.javeriana.funkoStore.services.IProductoService;

@RestController
@RequestMapping("productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("getProductos/{page}/{size}")
	Page<ProductoDTO> getAllProductos(@PathVariable("page") int page, @PathVariable("size") int size) {
		return transformarDTO(productoService.getAllProducts(PageRequest.of(page, size)), PageRequest.of(page, size));
	}

	@PutMapping("actualizar/{id}")
	public ProductoDTO actualizarProducto(@RequestBody Producto newProducto, @PathVariable Long id) {
		ModelMapper modelMapper = new ModelMapper();
		ProductoDTO productoDTO = modelMapper.map(productoService.updateProducto(newProducto, id), ProductoDTO.class);
		return productoDTO;
	}

	@PostMapping
	public ProductoDTO post(@RequestBody Producto newProducto) {
		ModelMapper modelMapper = new ModelMapper();
		ProductoDTO productoDTO = modelMapper.map(productoService.addProducto(newProducto), ProductoDTO.class);
		return productoDTO;
	}

	@DeleteMapping
	public String deleteAll() {
		productoService.deleteAllProducts();
		return "Se han eliminado todos los productos";
	}

	@DeleteMapping("/eliminar/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productoService.deleteProduct(id);
		return "Producto eliminado exitosamente";
	}

	public Page<ProductoDTO> transformarDTO(Page<Producto> productos, Pageable pageable) {
		List<ProductoDTO> pResult = new ArrayList<ProductoDTO>();
		for (Producto p : productos) {
			ProductoDTO pDTO = new ProductoDTO();
			pDTO.setId(p.getId());
			pDTO.setNombre(p.getNombre());
			pDTO.setPrecio(p.getPrecio());
			pDTO.setImagen(p.getImagen());
			pDTO.setDescripcion(p.getDescripcion());	
			pResult.add(pDTO);
		}
		Page<ProductoDTO> productosDTO = new PageImpl<ProductoDTO>(pResult, pageable, productos.getTotalElements());
		return productosDTO;
	}

}
