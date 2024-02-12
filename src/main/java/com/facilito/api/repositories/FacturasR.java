package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Facturas;

public interface FacturasR extends JpaRepository<Facturas, Long>{
	@Query(value="SELECT * FROM facturas f WHERE idabonado = ?1 AND  pagado = 0 AND estado = 1 AND f.formapago = 1 ORDER BY idabonado", nativeQuery=true)
	public List<Facturas> findByIdAbonado(Long idabonado); 

}
