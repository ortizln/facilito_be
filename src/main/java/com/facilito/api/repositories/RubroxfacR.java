package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Rubroxfac;

public interface RubroxfacR extends JpaRepository<Rubroxfac, Long>{
	
	@Query(value = "SELECT f.idfactura,  sum(rf.cantidad * rf.valorunitario) total from rubroxfac rf join facturas f on rf.idfactura_facturas = f.idfactura where f.idcliente = ?1 and f.pagado = 0 and f.fechaeliminacion is null group by f.idfactura", nativeQuery = true)
	public List<Object[]> findSincobro(Long idcliente);

}
