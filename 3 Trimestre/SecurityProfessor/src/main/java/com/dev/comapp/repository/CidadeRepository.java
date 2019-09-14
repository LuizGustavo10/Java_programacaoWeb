package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}