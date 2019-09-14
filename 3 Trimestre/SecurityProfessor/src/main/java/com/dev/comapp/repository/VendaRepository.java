package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Venda;
import com.dev.comapp.models.Post;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}