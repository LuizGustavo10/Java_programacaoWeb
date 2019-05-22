package com.example.comapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comapp.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	
		
	
}