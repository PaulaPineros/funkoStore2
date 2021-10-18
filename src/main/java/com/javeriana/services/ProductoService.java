package com.javeriana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.javeriana.funkoStore.entities.Producto;
import com.javeriana.funkoStore.repositories.ProductoRepository;

public class ProductoService implements IProductoService{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto addProducto(Producto newProducto) {
		return productoRepository.save(newProducto);
	}

	@Override
	public void deleteProduct(Long id) {
		java.util.Optional<Producto> p = productoRepository.findById(id);
		if(p != null){
			productoRepository.deleteById(id);
		}
	}
	
	@Override
	public void deleteAllProducts() {
		productoRepository.deleteAll();
	}


	@Override
	public Producto updateProducto(Producto newProducto, Long id) {
		return productoRepository.findById(id).map(provider ->{
			provider.setNombre(newProducto.getNombre());
			provider.setPrecio(newProducto.getPrecio());
			provider.setImagen(newProducto.getImagen());
			provider.setDescripcion(newProducto.getDescripcion());
			return productoRepository.save(provider);	
		}).get();
	}
	
	@Override
	public Page<Producto> getAllProducts(PageRequest pageRequest) {
		return productoRepository.findAll(pageRequest);
	}

}
