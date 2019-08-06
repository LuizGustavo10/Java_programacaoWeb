package com.cadastro.Cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.Cadastro.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
