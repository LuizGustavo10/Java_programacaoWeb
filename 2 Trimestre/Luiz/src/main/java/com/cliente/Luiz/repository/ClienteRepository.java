package com.cliente.Luiz.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.Luiz.models.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}