package com.dev.comapp.controllers;

import java.awt.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Funcionario;
import com.dev.comapp.repository.AlunoRepository;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.AlunoRepository;



@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@GetMapping("/funcionarios")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/funcionarioLista");
		java.util.List<Funcionario> lista =  repository.findAll();
		mv.addObject("obj", lista);		
		Locale loc= new Locale ("pt", "BR");
		//mv.addObject("localizacao",loc);
		
		return mv;
	}

	
	@GetMapping("/adicionarFuncionario")
	public ModelAndView add(Funcionario obj) {
		
		ModelAndView mv = new ModelAndView("/funcionarioAdicionar");
		mv.addObject("obj", obj);
		
		return mv;
	}
	
	@GetMapping("/editarFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario e = obj.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario e = obj.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarFuncionario")
	public ModelAndView save(@Valid Funcionario obj, BindingResult result) {
		
		if(result.hasErrors() ){
			return add(obj);
		}
		
		obj.setSenha(new BCryptPasswordEncoder().encode(obj.getSenha()));
				
		repository.saveAndFlush(obj);
		
		return buscarTodos();
	}
	
}
