package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.PermissoesFuncionario;

public interface PermissoesFuncionarioRepository extends JpaRepository<PermissoesFuncionario, Long>{
	


}