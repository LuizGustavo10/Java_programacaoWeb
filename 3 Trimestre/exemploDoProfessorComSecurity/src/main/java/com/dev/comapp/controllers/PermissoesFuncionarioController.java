package com.dev.comapp.controllers;

import java.awt.List;
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

import com.dev.comapp.models.PermissoesFuncionario;
import com.dev.comapp.repository.AlunoRepository;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.PapelRepository;
import com.dev.comapp.repository.PermissoesFuncionarioRepository;
import com.dev.comapp.repository.AlunoRepository;



@Controller
public class PermissoesFuncionarioController {
	
	@Autowired
	private PermissoesFuncionarioRepository repository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@GetMapping("/permissoes")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/permissaoFuncionarioLista");
		java.util.List<PermissoesFuncionario> lista =  repository.findAll();
		mv.addObject("obj", lista);		
		
		return mv;
	}

	
	@GetMapping("/adicionarPermissoesFuncionario")
	public ModelAndView add(PermissoesFuncionario obj) {
		
		ModelAndView mv = new ModelAndView("/permissaoFuncionarioAdicionar");
		mv.addObject("obj", obj);
		mv.addObject("funcionarios",funcionarioRepository.findAll());
		mv.addObject("papeis",papelRepository.findAll());		
		return mv;
	}
	
	@GetMapping("/editarPermissoesFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> obj = repository.findById(id);
		PermissoesFuncionario e = obj.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerPermissoesFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> obj = repository.findById(id);
		PermissoesFuncionario e = obj.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarPermissoesFuncionario")
	public ModelAndView save(@Valid PermissoesFuncionario obj, BindingResult result) {
		
		if(result.hasErrors() ){
			return add(obj);
		}
				
		repository.saveAndFlush(obj);
		
		return buscarTodos();
	}
	
}
