package com.javeriana.funkoStore.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.javeriana.funkoStore.entities.Producto;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository <Producto,Long>{
	
}
