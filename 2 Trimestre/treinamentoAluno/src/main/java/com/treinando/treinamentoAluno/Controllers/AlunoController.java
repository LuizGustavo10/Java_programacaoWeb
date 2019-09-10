package com.treinando.treinamentoAluno.Controllers;

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

import com.treinando.treinamentoAluno.Models.Aluno;
import com.treinando.treinamentoAluno.Repository.AlunoRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/alunos")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/alunoLista");
		List<Aluno> listaAlunos = repository.findAll();
		mv.addObject("alunos", listaAlunos);
		mv.addObject("quantidadeDeAlunos", listaAlunos.size());
		return mv;
	}
	
	@GetMapping("/addAluno")
	public ModelAndView add(Aluno aluno) {
		ModelAndView mv = new ModelAndView("alunoAdd");
		mv.addObject("aluno", aluno);
		return mv;
		
	}
	@GetMapping("/editarAluno/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Aluno> aluno = repository.findById(id);		
		Aluno a = aluno.get();
		return add(a);
	}
	@GetMapping("/removerAluno/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional <Aluno> aluno = repository.findById(id);
		Aluno a = aluno.get();
		repository.delete(a);
		return buscarTodos();
		
	}
	@PostMapping("/salvarAluno")
	public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
		repository.saveAndFlush(aluno);
		return buscarTodos();
	}
}
