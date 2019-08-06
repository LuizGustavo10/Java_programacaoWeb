package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Categoria;
import com.dev.comapp.models.Post;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}