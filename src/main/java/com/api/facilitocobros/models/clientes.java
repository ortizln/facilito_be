package com.api.facilitocobros.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class clientes {
private Long idcliente;
private String cedula; 
private String nombre; 
private String direccion; 
private String telefono; 
private Date fechanacimiento; 
private Long descapacitado; 
private Long porcdescapacidad; 
private Long porcexonera; 
private Long estado; 
private String email; 
private Long usucrea; 
private Nacionalidad idnacionalidad_nacionalidad;
private Date feccrea; 
private Long usumodi; 
private Date fecmodi; 
private Long idpjuridica_personeriajuridica; 


}
