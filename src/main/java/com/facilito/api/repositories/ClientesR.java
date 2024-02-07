package com.facilito.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facilito.api.models.Clientes;

public interface ClientesR extends JpaRepository<Clientes, Long>{

}
