package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long>{
	
	

}