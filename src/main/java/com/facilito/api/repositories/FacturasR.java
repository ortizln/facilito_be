package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.interfaces.FacturaI;
import com.facilito.api.models.Facturas;

public interface FacturasR extends JpaRepository<Facturas, Long> {

	@Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0  and idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY idabonado, idfactura", nativeQuery = true)
	public List<Facturas> findByIdCliente(Long idcliente);
	@Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0  and idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY idabonado, idfactura", nativeQuery = true)
	public List<FacturaI> findByIdCliente2(Long idcliente);

}
