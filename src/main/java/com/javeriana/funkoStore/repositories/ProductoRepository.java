package com.javeriana.funkoStore.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.javeriana.funkoStore.entities.Producto;

public interface ProductoRepository extends PagingAndSortingRepository <Producto,Long>{
	
}
