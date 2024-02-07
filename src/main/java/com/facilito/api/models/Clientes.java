package com.facilito.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idcliente;
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="fechanacimiento")
	private Date fechanacimiento;
	private Long descapacitado;
	private Long porcdescapacidad;
	private Long porcexonera;
	private Long estado;
	private String email;
	private Long usucrea;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idnacionalidad_nacionalidad")
	private Nacionalidad idnacionalidad_nacionalidad;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="feccrea")
	private Date feccrea;
	private Long usumodi;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name ="fecmodi")
	private Date fecmodi;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpjuridica_personeriajuridica")
	private PersoneriaJuridica idpjuridica_personeriajuridica;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtpidentifica_tpidentifica")
	private TpIdentifica idtpidentifica_tpidentifica; 
	

}
