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
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/alunos")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/alunosLista");
		java.util.List<Aluno> listaAlunos =  repository.findAll();
		mv.addObject("alunos", listaAlunos);
		mv.addObject("quantidadeAlunos", listaAlunos.size());
		
		return mv;
	}
	
	//BUSCAR ALUNO POR NOME
	@GetMapping("/buscarAlunoNome")
	public ModelAndView buscarAlunos(String nome) {		
		ModelAndView mv = new ModelAndView("/alunosLista");
		mv.addObject("alunos", repository.buscarPorNome(nome));		
		return mv;
	}
	
	
	
	
	
	
	@GetMapping("/addAluno")
	public ModelAndView add(Aluno categoria) {
		
		ModelAndView mv = new ModelAndView("/alunoAdd");
		mv.addObject("aluno", categoria);
		
		return mv;
	}
	
	@GetMapping("/editarAluno/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Aluno> categoria = repository.findById(id);
		Aluno e = categoria.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerAluno/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Aluno> categoria = repository.findById(id);
		Aluno e = categoria.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarAluno")
	public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
		
		if(result.hasErrors()  || !aluno.getCpf().equals(11)) {
			return add(aluno);
		}
		
		repository.saveAndFlush(aluno);
		
		return buscarTodos();
	}
	
}
