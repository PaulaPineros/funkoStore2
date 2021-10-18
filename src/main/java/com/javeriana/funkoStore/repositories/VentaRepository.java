package com.javeriana.funkoStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javeriana.funkoStore.entities.Venta;

@Repository
public interface VentaRepository extends JpaRepository <Venta,Long>{
	
	@Query("SELECT v FROM Venta v WHERE v.fecha < :fecha")
	List<Venta> findByDate(Long fecha);
}
