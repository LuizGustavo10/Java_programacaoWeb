package com.viagem.Viagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viagem.Viagens.models.Reserva;

public interface ReservaRepository  extends JpaRepository <Reserva, Long>{
	
	List<Reserva> findByDestino(String destino);
	
	@Query("select e from Reserva e where e.destino like %?1%")
	List<Reserva> buscarPorDestino(String destino);
}
