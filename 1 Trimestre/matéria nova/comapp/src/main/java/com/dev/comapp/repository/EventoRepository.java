package com.dev.comapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	
		
	List<Evento> findByLocal(String local);	
}