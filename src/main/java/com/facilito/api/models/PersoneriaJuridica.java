package com.facilito.api.models;


import jakarta.persistence.*;

@Entity
@Table(name="personeriajuridica")
public class PersoneriaJuridica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idpjuridica;
	private String descripcion;
	public PersoneriaJuridica() {
		super();
	}
	public PersoneriaJuridica(Long idpjuridica, String descripcion) {
		super();
		this.idpjuridica = idpjuridica;
		this.descripcion = descripcion;
	}
	public Long getIdpjuridica() {
		return idpjuridica;
	}
	public void setIdpjuridica(Long idpjuridica) {
		this.idpjuridica = idpjuridica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 

}
