package com.facilito.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
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
	private Long discapacitado;
	private Long porcdiscapacidad;
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
	
	public Clientes() {
		super();
	}
	public Clientes(Long idcliente, String cedula, String nombre, String direccion, String telefono,
			Date fechanacimiento, Long discapacitado, Long porcdiscapacidad, Long porcexonera, Long estado,
			String email, Long usucrea, Nacionalidad idnacionalidad_nacionalidad, Date feccrea, Long usumodi,
			Date fecmodi, PersoneriaJuridica idpjuridica_personeriajuridica, TpIdentifica idtpidentifica_tpidentifica) {
		super();
		this.idcliente = idcliente;
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechanacimiento = fechanacimiento;
		this.discapacitado = discapacitado;
		this.porcdiscapacidad = porcdiscapacidad;
		this.porcexonera = porcexonera;
		this.estado = estado;
		this.email = email;
		this.usucrea = usucrea;
		this.idnacionalidad_nacionalidad = idnacionalidad_nacionalidad;
		this.feccrea = feccrea;
		this.usumodi = usumodi;
		this.fecmodi = fecmodi;
		this.idpjuridica_personeriajuridica = idpjuridica_personeriajuridica;
		this.idtpidentifica_tpidentifica = idtpidentifica_tpidentifica;
	}
	public Long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public Long getDiscapacitado() {
		return discapacitado;
	}
	public void setDiscapacitado(Long discapacitado) {
		this.discapacitado = discapacitado;
	}
	public Long getPorcdiscapacidad() {
		return porcdiscapacidad;
	}
	public void setPorcdiscapacidad(Long porcdiscapacidad) {
		this.porcdiscapacidad = porcdiscapacidad;
	}
	public Long getPorcexonera() {
		return porcexonera;
	}
	public void setPorcexonera(Long porcexonera) {
		this.porcexonera = porcexonera;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUsucrea() {
		return usucrea;
	}
	public void setUsucrea(Long usucrea) {
		this.usucrea = usucrea;
	}
	public Nacionalidad getIdnacionalidad_nacionalidad() {
		return idnacionalidad_nacionalidad;
	}
	public void setIdnacionalidad_nacionalidad(Nacionalidad idnacionalidad_nacionalidad) {
		this.idnacionalidad_nacionalidad = idnacionalidad_nacionalidad;
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
	public PersoneriaJuridica getIdpjuridica_personeriajuridica() {
		return idpjuridica_personeriajuridica;
	}
	public void setIdpjuridica_personeriajuridica(PersoneriaJuridica idpjuridica_personeriajuridica) {
		this.idpjuridica_personeriajuridica = idpjuridica_personeriajuridica;
	}
	public TpIdentifica getIdtpidentifica_tpidentifica() {
		return idtpidentifica_tpidentifica;
	}
	public void setIdtpidentifica_tpidentifica(TpIdentifica idtpidentifica_tpidentifica) {
		this.idtpidentifica_tpidentifica = idtpidentifica_tpidentifica;
	} 
	
	

}
