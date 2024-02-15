package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Abonados;

public interface AbonadosR extends JpaRepository<Abonados, Long>{
@Query(value="SELECT * FROM abonados a JOIN clientes c ON a.idcliente_clientes = c.idcliente WHERE c.cedula LIKE %?1%", nativeQuery = true)
List<Abonados> findByCedula(String identificacion);
}
