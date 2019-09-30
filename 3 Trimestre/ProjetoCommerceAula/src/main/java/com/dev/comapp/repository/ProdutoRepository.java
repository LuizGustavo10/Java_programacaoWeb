package com.dev.comapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
