package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Produto;
import com.dev.comapp.models.Post;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}