package com.facilito.api.apis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facilito.api.excepciones.ResourceNotFound;
import com.facilito.api.models.Facturas;
import com.facilito.api.models.Rubros;
import com.facilito.api.models.Rubroxfac;
import com.facilito.api.repositories.FacturasR;
import com.facilito.api.repositories.RubroxfacR;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturasApi {
	@Autowired
	private FacturasR facturasR;
	@Autowired
	private RubroxfacR rubroxfacR;

	@GetMapping("/abonado")
	public ResponseEntity<List<Facturas>> getByIdAbonado(@RequestParam("cuenta") Long cuenta) {
		List<Facturas> facturas = facturasR.findByIdAbonado(cuenta);
		if (facturas.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			for (Facturas factura : facturas) {
				Double valorPago = 0.0;
				for (Rubros rubro : factura.getRubros()) {
					Rubroxfac rubroxfac = rubroxfacR.findByIdFacIdRub(factura.getIdfactura(), rubro.getIdrubro());
					rubro.setValor(rubroxfac.getValorunitario());
					valorPago += rubro.getValor().doubleValue();
				}
				factura.setTotaltarifa(new BigDecimal(valorPago));
			}
			return ResponseEntity.ok(facturas);
		}
	}

	@PutMapping("/{idfactura}")
    public ResponseEntity<Facturas> updateFacturas(@PathVariable Long idfacturas, Facturas facturas){
    	Facturas factura = facturasR.findById(idfacturas).orElseThrow(()-> new ResourceNotFound("Factura no encontrada" + idfacturas));
    	factura.setIdmodulo(facturas.getIdmodulo());
    	factura.setIdcliente(facturas.getIdcliente());
    	factura.setNrofactura(facturas.getNrofactura());
    	factura.setPorcexoneracion(facturas.getPorcexoneracion());
    	factura.setRazonexonera(facturas.getRazonexonera());
    	factura.setTotaltarifa(facturas.getTotaltarifa());
    	factura.setPagado(facturas.getPagado());
    	factura.setUsuariocobro(facturas.getUsuariocobro());
    	factura.setFechaanulacion(facturas.getFechaanulacion());
    	factura.setRazonanulacion(facturas.getRazonanulacion());
    	factura.setUsuarioeliminacion(facturas.getUsuarioeliminacion());
    	factura.setFechaeliminacion(facturas.getFechaeliminacion());
    	factura.setRazoneliminacion(facturas.getRazoneliminacion());
    	factura.setConveniopago(facturas.getConveniopago());
    	factura.setFechaconvenio(facturas.getFechaconvenio()); 
    	factura.setEstadoconvenio(facturas.getEstadoconvenio());
    	factura.setFormapago(facturas.getFormapago());
    	factura.setRefeformapago(facturas.getRefeformapago());
    	factura.setHoracobro(facturas.getHoracobro());
    	factura.setUsuariotransferencia(facturas.getUsuariotransferencia());
    	factura.setUsucrea(facturas.getUsucrea());
    	factura.setFeccrea(facturas.getFeccrea());
    	factura.setUsumodi(facturas.getUsumodi());
    	factura.setFecmodi(facturas.getFecmodi());
    	factura.setValorbase(facturas.getValorbase());
    	factura.setIdabonado(facturas.getIdabonado());    	
    	Facturas updateFactura = facturasR.save(factura); 
    	return ResponseEntity.ok(updateFactura); 
    }
}
