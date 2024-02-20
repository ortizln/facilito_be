package com.facilito.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;

@Entity
@Table(name = "intereses")
public class Intereses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinteres;
	private Long anio;
	private Long mes;
	private Double porcentaje;
	private Long usucrea;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "feccrea")
	private Date feccrea;
	private Long usumodi;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecmodi")
	private Date fecmodi;

	public Intereses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intereses(Long idinteres, Long anio, Long mes, Double porcentaje, Long usucrea, Date feccrea, Long usumodi,
			Date fecmodi) {
		super();
		this.idinteres = idinteres;
		this.anio = anio;
		this.mes = mes;
		this.porcentaje = porcentaje;
		this.usucrea = usucrea;
		this.feccrea = feccrea;
		this.usumodi = usumodi;
		this.fecmodi = fecmodi;
	}

	public Long getIdInteres() {
		return idinteres;
	}

	public void setIdInteres(Long idinteres) {
		this.idinteres = idinteres;
	}

	public Long getAnio() {
		return anio;
	}

	public void setAnio(Long anio) {
		this.anio = anio;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
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
