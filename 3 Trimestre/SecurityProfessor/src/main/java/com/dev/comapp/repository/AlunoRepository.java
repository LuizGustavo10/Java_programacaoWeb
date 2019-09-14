package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Aluno;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Post;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Query("select e from aluno e where e.nome like %?1%")
	List<Aluno> buscarPorNome(String nome);
}