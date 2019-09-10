package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.ItensVenda;
import com.dev.comapp.models.Post;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long>{

}