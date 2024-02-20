package com.facilito.api.apis;

import java.util.ArrayList;
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
import com.facilito.api.models.Abonados;
import com.facilito.api.models.Clientes;
import com.facilito.api.models.Facturas;
import com.facilito.api.repositories.AbonadosR;
import com.facilito.api.repositories.ClientesR;
import com.facilito.api.repositories.FacturasR;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturasApi {
	@Autowired
	private FacturasR facturasR;
	@Autowired
	private ClientesR clientesR;
	@Autowired
	private AbonadosR abonadosR;

	@GetMapping("/sincobro")
	public ResponseEntity<List<Facturas>> getSinCobro(@RequestParam("opt") Long opt,
			@RequestParam("dato") String dato) {
		if (opt == 1) {
			List<Clientes> clientes = clientesR.findByCedula(dato);
			if (!clientes.isEmpty()) {
				List<Facturas> facturas = new ArrayList<>();
				clientes.forEach((Clientes c) -> {
					List<Facturas> factura = facturasR.findByIdCliente(c.getIdcliente());
					if(!factura.isEmpty()){
					facturas.addAll(factura);
					}
					
				});
				return ResponseEntity.ok(facturas);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else if (opt == 2) {
			Abonados abonado = abonadosR.findByCuenta(Long.valueOf(dato));
			List<Facturas> facturas = facturasR.findByIdCliente(abonado.getIdcliente_clientes().getIdcliente());
			return ResponseEntity.ok(facturas);
		} else {
			return ResponseEntity.noContent().build();
		}
	}


	public ResponseEntity<Facturas> errorMessage() {
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{idfactura}")
	public ResponseEntity<Facturas> updateFacturas(@PathVariable Long idfactura, Facturas facturas) {
		@SuppressWarnings("null")
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
