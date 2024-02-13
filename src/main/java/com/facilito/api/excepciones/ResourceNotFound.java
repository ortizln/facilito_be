package com.facilito.api.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	private static final Long SERIALVERSIONUID_LONG = 1L; 
	public ResourceNotFound(String mensaje) {
		super(mensaje);
	}

}
