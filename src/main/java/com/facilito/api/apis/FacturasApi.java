package com.facilito.api.apis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
					if (!factura.isEmpty()) {
						facturas.addAll(factura);
					}

				});

				facturas.forEach((Facturas f) -> {
					if (f.getIdmodulo().getIdmodulo() == 3) {
						f.setTotaltarifa(f.getTotaltarifa().add(new BigDecimal(1)));
					}

				});
				return ResponseEntity.ok(facturas);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else if (opt == 2) {
			Abonados abonado = abonadosR.findByCuenta(Long.valueOf(dato));
			List<Facturas> facturas = facturasR.findByIdCliente(abonado.getIdcliente_clientes().getIdcliente());
			facturas.forEach((Facturas f) -> {
				if (f.getIdmodulo().getIdmodulo() == 3) {
					f.setTotaltarifa(f.getTotaltarifa().add(new BigDecimal(1)));
				}

			});
			return ResponseEntity.ok(facturas);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/sincobro/v2")
	public ResponseEntity<List<FacturaI>> getSinCobro2(@RequestParam("opt") Long opt,
			@RequestParam("dato") String dato) {
		if (opt == 1) {
			List<Clientes> clientes = clientesR.findByCedula(dato);
			if (!clientes.isEmpty()) {
				List<FacturaI> facturas = new ArrayList<>();
				clientes.forEach((Clientes c) -> {
					List<FacturaI> factura = facturasR.findByIdCliente2(c.getIdcliente());
					if (!factura.isEmpty()) {
						facturas.addAll(factura);
					}

				});
				facturas.forEach((FacturaI f) -> {
					if (f.getIdmodulo() == 3) {
						f.getTotaltarifa().add(new BigDecimal(1));
					}
				});
				return ResponseEntity.ok(facturas);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else if (opt == 2) {
			Abonados abonado = abonadosR.findByCuenta(Long.valueOf(dato));
			List<FacturaI> facturas = facturasR.findByIdCliente2(abonado.getIdcliente_clientes().getIdcliente());
			facturas.forEach((FacturaI f) -> {
				if (f.getIdmodulo() == 3) {
					f.getTotaltarifa().add(new BigDecimal(1));
				}
			});
			return ResponseEntity.ok(facturas);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/sincobro/v3")
	public ResponseEntity<List<Map<String, Object>>> getSinCobro3(@RequestParam("opt") Long opt,
			@RequestParam("dato") String dato) {
		if (opt == 1) {
			return ResponseEntity.ok(facturasR.findByIdCliente3(Long.valueOf(dato)));
		} else {
			return ResponseEntity.noContent().build();
		}
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
