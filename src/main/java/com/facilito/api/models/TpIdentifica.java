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
@Table(name="tpidentifica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
