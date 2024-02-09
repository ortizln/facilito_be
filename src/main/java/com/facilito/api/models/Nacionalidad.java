package com.facilito.api.models;



import jakarta.persistence.*;

@Entity
@Table(name = "nacionalidad")
public class Nacionalidad{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idnacionalidad;
	private String descripcion;
	public Nacionalidad() {
		super();
	}
	public Nacionalidad(Long idnacionalidad, String descripcion) {
		super();
		this.idnacionalidad = idnacionalidad;
		this.descripcion = descripcion;
	}
	public Long getIdnacionalidad() {
		return idnacionalidad;
	}
	public void setIdnacionalidad(Long idnacionalidad) {
		this.idnacionalidad = idnacionalidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
