package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Produto;
import com.dev.comapp.models.Categoria;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByNome(String nome);
	
	@Query("select e from Produto e where e.nome like %?1%")
	List<Produto> buscarPorNome(String nome);
	
//	@Query("select e from Produto e where e.categoria like 33")
	@Query("select e from Produto e where e.categoria.id = ?1")
	List<Produto>findByMouse(long id);

}