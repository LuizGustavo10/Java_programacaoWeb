package com.treinando.treinamentoAluno.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treinando.treinamentoAluno.Models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
