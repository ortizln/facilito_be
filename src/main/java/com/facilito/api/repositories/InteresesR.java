package com.facilito.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facilito.api.models.Intereses;

public interface InteresesR extends JpaRepository<Intereses, Long>{
@Query(value="SELECT * FROM intereses WHERE anio = ?1 and mes = ?2",nativeQuery= true)
public List<Intereses> findByAnioMes(Long anio, Long mes); 
}
