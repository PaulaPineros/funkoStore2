package com.javeriana.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.javeriana.funkoStore.entities.Producto;

public interface IProductoService {
	
	Producto addProducto(Producto newProducto);
	void deleteProduct(Long id);
	void deleteAllProducts();
	Producto updateProducto(Producto newProducto, Long id);
	Page<Producto> getAllProducts(PageRequest pageRequest);
}
