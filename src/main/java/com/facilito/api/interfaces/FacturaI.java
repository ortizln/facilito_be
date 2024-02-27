package com.facilito.api.interfaces;

import java.math.BigDecimal;

//import com.facilito.api.models.Facturas;
//@Projection(name = "FacturaI", types = Facturas.class)
public interface FacturaI {
	Long getIdfactura();
	BigDecimal getTotaltarifa();
	Long getidcliente();
	Modulos getIdmodulo();
	interface Modulos{
		Long getIdmodulo();
		String getDescripcion();
	}
	
	
}
