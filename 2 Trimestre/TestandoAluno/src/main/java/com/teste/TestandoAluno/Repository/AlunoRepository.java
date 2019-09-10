package com.teste.TestandoAluno.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.TestandoAluno.Models.Aluno;



public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Query("select e from aluno e where e.nome like %?1%")
	List<Aluno> buscarPorNome(String nome);
}