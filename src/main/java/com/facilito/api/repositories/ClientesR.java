package com.facilito.api.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Clientes;

public interface ClientesR extends JpaRepository<Clientes, Long>{
	
@Query(value= "SELECT * FROM clientes WHERE cedula like ?1 ORDER BY nombre", nativeQuery = true)
List<Clientes> findByCedula(String identificacion);
}
