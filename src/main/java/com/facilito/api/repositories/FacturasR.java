package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.interfaces.FacturaI;
import com.facilito.api.models.Facturas;

public interface FacturasR extends JpaRepository<Facturas, Long> {

	@Query(value = "SELECT * FROM facturas f WHERE f.idabonado = ?1 AND f.fechaconvenio is null and f.fechacobro is null AND f.formapago = 1 AND f.estado = 1 ORDER BY f.idabonado, f.idfactura", nativeQuery = true)
	public List<Facturas> findByIdAbonado(Long idabonado);

	@Query(value = "SELECT * FROM facturas f WHERE f.idcliente = ?1 and fechaconvenio is null and fechacobro is null AND f.formapago = 1 AND f.estado = 1 ORDER BY idabonado, idfactura", nativeQuery = true)
	public List<Facturas> findByIdCliente(Long idcliente);
	
	@Query(value = "SELECT * FROM facturas f WHERE f.idabonado = ?1 AND f.fechaconvenio is null and f.fechacobro is null AND f.formapago = 1 AND f.estado = 1 ORDER BY f.idabonado, f.idfactura", nativeQuery = true)
	public List<FacturaI> findBy(Long idabonado);
	
	@Query(value = "SELECT * FROM facturas WHERE totaltarifa > 0 and estado = 1 and idcliente=?1 and fechaconvenio is null and fechacobro is null ORDER BY idabonado, idfactura", nativeQuery=true)
	public List<Facturas> findSinCobro(Long idcliente);

}
