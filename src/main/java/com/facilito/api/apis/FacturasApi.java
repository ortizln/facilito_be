package com.facilito.api.apis;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facilito.api.models.Facturas;
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
            BigDecimal valor;
            for (Facturas factura : facturas) {
                System.out.println("--------------------------");
                System.out.println(factura.getIdfactura());
                List<Rubroxfac> rubroxfac = rubroxfacR.findByIdFactura(factura.getIdfactura());
                for (Rubroxfac ruxfa : rubroxfac) {
                    // factura.setRubros(ruxfa.getIdrubro_rubros());
                    BigDecimal valorunitario = ruxfa.getValorunitario(); 
                    System.out.println(ruxfa.getValorunitario());
                    //valor += valorunitario;
                }
                
            }
            return ResponseEntity.ok(facturas);
        }
    }
}
