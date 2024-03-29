package com.facilito.api.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facilito.api.models.Clientes;
import com.facilito.api.repositories.ClientesR;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClientesApi {
	@Autowired
	private ClientesR clientesR; 
	@GetMapping("/identificacion")
	@ResponseStatus(HttpStatus.OK)
	public List<Clientes> findByCedula(@RequestParam("identificacion") String identificacion){
		return clientesR.findByCedula(identificacion);
	}
	

}
