package com.facilito.api.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nacionalidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nacionalidad{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idnacionalidad;
	private String descipcion;
}
