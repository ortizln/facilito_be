package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Rubroxfac;

public interface RubroxfacR extends JpaRepository<Rubroxfac, Long>{
	@Query(value="SELECT * FROM rubroxfac WHERE idfactura_facturas = ?1 ORDER BY idrubro_rubros",nativeQuery = true)
	public List<Rubroxfac> findByIdFactura(Long idfactura);

}
