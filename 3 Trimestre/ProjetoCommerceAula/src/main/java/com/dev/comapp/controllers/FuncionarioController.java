package com.dev.comapp.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Cidade;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.CidadeRepository;



@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping("/funcionarios")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/funcionarioLista");
		java.util.List<Funcionario> listaFuncionarios =  repository.findAll();
		mv.addObject("funcionarios", listaFuncionarios);
		mv.addObject("quantidadeFuncionarios", listaFuncionarios.size());
		
		return mv;
	}
	
//	//BUSCAR ALUNO POR NOME
//	@GetMapping("/buscarFuncionarioNome")
//	public ModelAndView buscarFuncionarios(String nome) {		
//		ModelAndView mv = new ModelAndView("/funcionarioLista");
//		mv.addObject("funcionarios", repository.buscarPorNome(nome));		
//		return mv;
//	}
	
	
	
	
	
	
	@GetMapping("/adicionarFuncionario")
	public ModelAndView add(Funcionario categoria) {
		
		
		ModelAndView mv = new ModelAndView("/funcionarioAdd");
		mv.addObject("funcionario", categoria);
		List<Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades",listaCidade);
		
		return mv;
	}
	
	@GetMapping("/editarFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Funcionario> categoria = repository.findById(id);
		Funcionario e = categoria.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Funcionario> categoria = repository.findById(id);
		Funcionario e = categoria.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarFuncionario")
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult result) {
		
//		if(result.hasErrors()  || !funcionario.getCpf().equals(11)) {
//			return add(funcionario);
//		}
		
		repository.saveAndFlush(funcionario);
		
		return buscarTodos();
	}
	
}
