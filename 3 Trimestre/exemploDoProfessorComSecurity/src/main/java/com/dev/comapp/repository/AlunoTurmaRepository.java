package com.dev.comapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Aluno;
import com.dev.comapp.models.AlunoTurma;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Long>{
	
	@Query("select e from AlunoTurma e where e.turma.id = ?1")
	List<AlunoTurma> buscarPorTurma(Long id);
}
