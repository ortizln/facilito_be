package com.facilito.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.facilito.api.models.Facturas;

public interface FacturasR extends JpaRepository<Facturas, Long> {

	// @Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0 and idcliente=?1
	// and fechaconvenio is null and fechacobro is null ORDER BY idabonado,
	// idfactura", nativeQuery = true)

/* 	@Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0 and idcliente=?1 and (( (estado = 1 or estado = 2) and fechacobro is null) or estado = 3 ) and fechaconvenio is null and fechaanulacion is null and fechaeliminacion is null ORDER BY idabonado, idfactura", nativeQuery = true)
	public List<Facturas> findByIdCliente(Long idcliente); */

	/*@Query("SELECT new map(" + "c.idfactura"
			+ " ) FROM Facturas f WHERE f.totaltarifa > 0 and f.idcliente=?1 and (( (f.estado = 1 or f.estado = 2) and f.fechacobro is null) or f.estado = 3 ) and f.fechaconvenio is null and f.fechaanulacion is null and f.fechaeliminacion is null ORDER BY f.idabonado, f.idfactura")
	List<Map<String, Object>> findByIdCliente3(Long idcliente);
*/
	/*@Query("SELECT new map(" + "f.idcliente as idcliente, "
			+ "FROM Facturas f WHERE f.totaltarifa > 0  and f.idcliente=?1 and f.fechaconvenio is null and f.fechacobro is null ORDER BY f.idabonado, f.idfactura")
	List<Map<String, Object>> findByIdCliente3(Long idcliente);
*/
}
