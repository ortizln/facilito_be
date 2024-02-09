package com.facilito.api.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.*;

@Entity
@Table(name = "abonados")
public class Abonados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idabonado;
	private String nromedidor;
	private Long lecturainicial;
	private Long estado;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechainstalacion")
	private Date fechainstalacion;
	private String marca;
	private Long secuencia;
	private String direccionubicacion;
	private String localizacion;
	private String observacion;
	private String departamento;
	private String piso;
	private Long idresponsable;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria_categorias")
	private Categorias idcategoria_categorias;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idruta_rutas")
	private Rutas idruta_rutas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente_clientes")
	private Clientes idcliente_clientes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idubicacionm_ubicacionm")
	private Ubicacionm idubicacionm_ubicacionm;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipopago_tipopago")
	private Tipopago idtipopago_tipopago;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idestadom_estadom")
	private Estadom idestadom_estadom;
	private Long medidorprincipal;
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

	public Abonados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abonados(Long idabonado, String nromedidor, Long lecturainicial, Long estado, Date fechainstalacion,
			String marca, Long secuencia, String direccionubicacion, String localizacion, String observacion,
			String departamento, String piso, Long idresponsable, Categorias idcategoria_categorias, Rutas idruta_rutas,
			Clientes idcliente_clientes, Ubicacionm idubicacionm_ubicacionm, Tipopago idtipopago_tipopago,
			Estadom idestadom_estadom, Long medidorprincipal, Long usucrea, Date feccrea, Long usumodi, Date fecmodi) {
		super();
		this.idabonado = idabonado;
		this.nromedidor = nromedidor;
		this.lecturainicial = lecturainicial;
		this.estado = estado;
		this.fechainstalacion = fechainstalacion;
		this.marca = marca;
		this.secuencia = secuencia;
		this.direccionubicacion = direccionubicacion;
		this.localizacion = localizacion;
		this.observacion = observacion;
		this.departamento = departamento;
		this.piso = piso;
		this.idresponsable = idresponsable;
		this.idcategoria_categorias = idcategoria_categorias;
		this.idruta_rutas = idruta_rutas;
		this.idcliente_clientes = idcliente_clientes;
		this.idubicacionm_ubicacionm = idubicacionm_ubicacionm;
		this.idtipopago_tipopago = idtipopago_tipopago;
		this.idestadom_estadom = idestadom_estadom;
		this.medidorprincipal = medidorprincipal;
		this.usucrea = usucrea;
		this.feccrea = feccrea;
		this.usumodi = usumodi;
		this.fecmodi = fecmodi;
	}

	public Long getIdabonado() {
		return idabonado;
	}

	public void setIdabonado(Long idabonado) {
		this.idabonado = idabonado;
	}

	public String getNromedidor() {
		return nromedidor;
	}

	public void setNromedidor(String nromedidor) {
		this.nromedidor = nromedidor;
	}

	public Long getLecturainicial() {
		return lecturainicial;
	}

	public void setLecturainicial(Long lecturainicial) {
		this.lecturainicial = lecturainicial;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Date getFechainstalacion() {
		return fechainstalacion;
	}

	public void setFechainstalacion(Date fechainstalacion) {
		this.fechainstalacion = fechainstalacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public String getDireccionubicacion() {
		return direccionubicacion;
	}

	public void setDireccionubicacion(String direccionubicacion) {
		this.direccionubicacion = direccionubicacion;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Long getIdresponsable() {
		return idresponsable;
	}

	public void setIdresponsable(Long idresponsable) {
		this.idresponsable = idresponsable;
	}

	public Categorias getIdcategoria_categorias() {
		return idcategoria_categorias;
	}

	public void setIdcategoria_categorias(Categorias idcategoria_categorias) {
		this.idcategoria_categorias = idcategoria_categorias;
	}

	public Rutas getIdruta_rutas() {
		return idruta_rutas;
	}

	public void setIdruta_rutas(Rutas idruta_rutas) {
		this.idruta_rutas = idruta_rutas;
	}

	public Clientes getIdcliente_clientes() {
		return idcliente_clientes;
	}

	public void setIdcliente_clientes(Clientes idcliente_clientes) {
		this.idcliente_clientes = idcliente_clientes;
	}

	public Ubicacionm getIdubicacionm_ubicacionm() {
		return idubicacionm_ubicacionm;
	}

	public void setIdubicacionm_ubicacionm(Ubicacionm idubicacionm_ubicacionm) {
		this.idubicacionm_ubicacionm = idubicacionm_ubicacionm;
	}

	public Tipopago getIdtipopago_tipopago() {
		return idtipopago_tipopago;
	}

	public void setIdtipopago_tipopago(Tipopago idtipopago_tipopago) {
		this.idtipopago_tipopago = idtipopago_tipopago;
	}

	public Estadom getIdestadom_estadom() {
		return idestadom_estadom;
	}

	public void setIdestadom_estadom(Estadom idestadom_estadom) {
		this.idestadom_estadom = idestadom_estadom;
	}

	public Long getMedidorprincipal() {
		return medidorprincipal;
	}

	public void setMedidorprincipal(Long medidorprincipal) {
		this.medidorprincipal = medidorprincipal;
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
