package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Aluno;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.models.Post;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{


}