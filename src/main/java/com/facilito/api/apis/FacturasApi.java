package com.facilito.api.apis;

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
import com.facilito.api.interfaces.FacturaI;
import com.facilito.api.models.Facturas;
import com.facilito.api.models.Modulos;
import com.facilito.api.repositories.AbonadosR;
import com.facilito.api.repositories.ClientesR;
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
	@Autowired
	private ClientesR clientesR;
	@Autowired
	private AbonadosR abonadosR;

	@GetMapping("/sincobro")
	public void getByIdAbonado(@RequestParam("opt") Long opt, @RequestParam("cuenta") Long cuenta) {
		List<Facturas> facturas;
		List<FacturaI> facturaI;
		if (opt == 1) {
			this.findFacturas(cuenta);
		} else if (opt == 2) {
			//List<Clientes> cliente = clientesR.findByCedula(String.valueOf(cuenta));
			//List<Abonados> abonado = abonadosR.findByCedula(String.valueOf(cuenta));
			/*for (Abonados cient : abonado) {
				if (abonado.isEmpty()) {
					System.out.println("Clientes is empty");
				} else {
					System.out.println(cient.getIdabonado());
					//facturas = facturasR.findByIdCliente(cient.getIdcliente());
				}
			}*/
		} else {
			this.errorMessage();
		}
	}
	@GetMapping("/sincobro/cuenta")
	public ResponseEntity<List<FacturaI>> getByCliente(@RequestParam("cuenta") Long cuenta) {
		List<FacturaI> facturas = facturasR.findBy(cuenta);
		return ResponseEntity.ok(facturas);
	}
	public ResponseEntity<List<Facturas>> findFacturas(Long cuenta) {
		List<Facturas> facturas = facturasR.findByIdAbonado(cuenta);
		if (facturas.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			facturas.forEach((item) -> {
				Modulos modulo = item.getIdmodulo();
				if (modulo.getIdmodulo() == 3) {
					System.out.println(item.getTotaltarifa());
				}
			});
		}
		return ResponseEntity.ok(facturas);
	}
	
	public ResponseEntity<Facturas> errorMessage(){
		return ResponseEntity.notFound().build(); 
	}

	@PutMapping("/{idfactura}")
	public ResponseEntity<Facturas> updateFacturas(@PathVariable Long idfactura, Facturas facturas) {
		Facturas factura = facturasR.findById(idfactura)
				.orElseThrow(() -> new ResourceNotFound("Factura no encontrada" + idfactura));
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
