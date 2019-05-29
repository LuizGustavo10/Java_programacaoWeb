package com.example.comapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comapp.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
		
	
}