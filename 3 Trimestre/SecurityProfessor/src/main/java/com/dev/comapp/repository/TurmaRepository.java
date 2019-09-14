package com.dev.comapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.comapp.models.Turma;
import com.dev.comapp.models.Post;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

}