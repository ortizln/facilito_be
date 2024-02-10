package com.facilito.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;

@Entity
@Table(name="categorias")
public class Categorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria; 
	private String descripcion; 
	private Long usucrea; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="feccrea")
	private Date feccrea; 
	private Long usumodi; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="fecmodi")
	private Date fecmodi; 
	private Boolean habilitado; 
	private String codigo; 
	private Long fijoagua; 
	private Long fijosanea;
	public Categorias() {
		super();
		
	}
	public Categorias(Long idcategoria, String descripcion, Long usucrea, Date feccrea, Long usumodi, Date fecmodi,
			Boolean habilitado, String codigo, Long fijoagua, Long fijosanea) {
		super();
		this.idcategoria = idcategoria;
		this.descripcion = descripcion;
		this.usucrea = usucrea;
		this.feccrea = feccrea;
		this.usumodi = usumodi;
		this.fecmodi = fecmodi;
		this.habilitado = habilitado;
		this.codigo = codigo;
		this.fijoagua = fijoagua;
		this.fijosanea = fijosanea;
	}
	public Long getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getUsucrea() {
		return usucrea;
	}
	public void setUsucrea(Long usucrea) {
		this.usucrea = usucrea;
	}
	public Date getFeccrea() {
		return feccrea;
	}
	public void setFeccrea(Date feccrea) {
		this.feccrea = feccrea;
	}
	public Long getUsumodi() {
		return usumodi;
	}
	public void setUsumodi(Long usumodi) {
		this.usumodi = usumodi;
	}
	public Date getFecmodi() {
		return fecmodi;
	}
	public void setFecmodi(Date fecmodi) {
		this.fecmodi = fecmodi;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getFijoagua() {
		return fijoagua;
	}
	public void setFijoagua(Long fijoagua) {
		this.fijoagua = fijoagua;
	}
	public Long getFijosanea() {
		return fijosanea;
	}
	public void setFijosanea(Long fijosanea) {
		this.fijosanea = fijosanea;
	} 

}
