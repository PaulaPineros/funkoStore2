package com.javeriana.funkoStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javeriana.funkoStore.entities.Venta;

public interface VentaRepository extends JpaRepository <Venta,Long>{
	
	@Query("SELECT v FROM Venta v WHERE FECHA(v.fecha) < :fecha")
	List<Venta> findByDate(Long fecha);
}
