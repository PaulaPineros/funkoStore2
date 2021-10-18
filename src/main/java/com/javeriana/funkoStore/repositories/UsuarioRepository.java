package com.javeriana.funkoStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.funkoStore.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long>{
	
}
