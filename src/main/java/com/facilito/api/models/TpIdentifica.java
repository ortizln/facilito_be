package com.facilito.api.models;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;

@Entity
@Table(name="tpidentifica")
public class TpIdentifica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idtpidentifica; 
	private String codigo; 
	private String nombre; 
	private Long usucrea; 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="feccrea")
	private Date feccrea; 
	private Long usumodi; 
	@jakarta.persistence.Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="fecmodi")
	private Date fecmodi;
	public TpIdentifica() {
		super();
	}
	public TpIdentifica(Long idtpidentifica, String codigo, String nombre, Long usucrea, Date feccrea, Long usumodi,
			Date fecmodi) {
		super();
		this.idtpidentifica = idtpidentifica;
		this.codigo = codigo;
		this.nombre = nombre;
		this.usucrea = usucrea;
		this.feccrea = feccrea;
		this.usumodi = usumodi;
		this.fecmodi = fecmodi;
	}
	public Long getIdtpidentifica() {
		return idtpidentifica;
	}
	public void setIdtpidentifica(Long idtpidentifica) {
		this.idtpidentifica = idtpidentifica;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
