package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.interfaces.FacturaI;
import com.facilito.api.models.Facturas;

public interface FacturasR extends JpaRepository<Facturas, Long> {

	// @Query(value = "SELECT 'idcliente' FROM facturas WHERE totaltarifa > 0 and
	// idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY
	// idabonado, idfactura", nativeQuery = true)
	@Query(nativeQuery = true,value = "SELECT * FROM facturas f WHERE totaltarifa > 0  and idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY idabonado, idfactura")
	public List<Facturas> findByIdCliente(Long idcliente);

	@Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0  and idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY idabonado, idfactura", nativeQuery = true)
	public List<FacturaI> findByIdCliente2(Long idcliente);

	/*@Query("SELECT new map(" + "f.idcliente as idcliente, "
			+ "FROM Facturas f WHERE f.totaltarifa > 0  and f.idcliente=?1 and f.fechaconvenio is null and f.fechacobro is null ORDER BY f.idabonado, f.idfactura")
	List<Map<String, Object>> findByIdCliente3(Long idcliente);
*/
}
