package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByNome(String nome);
	
	@Query("select e from Produto e where e.nome like %?1%")
	List<Produto> buscarPorNome(String nome);

}