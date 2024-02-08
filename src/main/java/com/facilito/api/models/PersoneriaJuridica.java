package com.facilito.api.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="personeriajuridica")
public class PersoneriaJuridica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idpjuridica;
	private String descripcion; 

}
