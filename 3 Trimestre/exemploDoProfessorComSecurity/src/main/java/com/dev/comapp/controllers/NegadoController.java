package com.dev.comapp.controllers;

import java.awt.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Aluno;
import com.dev.comapp.repository.AlunoRepository;
import com.dev.comapp.repository.AlunoRepository;



@Controller
public class NegadoController {
	

	
	@GetMapping("/negado")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/negado");
		
		
		return mv;
	}
	
	
	
}
