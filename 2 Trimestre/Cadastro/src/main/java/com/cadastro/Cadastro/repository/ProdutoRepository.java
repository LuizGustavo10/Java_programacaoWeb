package com.cadastro.Cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.Cadastro.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
