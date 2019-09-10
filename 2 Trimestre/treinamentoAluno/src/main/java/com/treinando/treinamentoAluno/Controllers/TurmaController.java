package com.treinando.treinamentoAluno.Controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.treinando.treinamentoAluno.Models.Turma;
import com.treinando.treinamentoAluno.Repository.TurmaRepository;

public class TurmaController {
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping("turmas")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/turmaLista");
		mv.addObject("turmas", repository.findAll());
		return mv;
	}
	@GetMapping("/addTurma")
	public ModelAndView add(Turma turma) {

		ModelAndView mv = new ModelAndView("turmaAdd");
		mv.addObject("turma", turma);

		return mv;
	}
	@GetMapping("/editarTurma/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Turma> turma = repository.findById(id);
		Turma t = turma.get();
		return add(t);
	}
	@GetMapping("/removerTurma/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<Turma> turma = repository.findById(id);
		Turma t = turma.get();
		repository.delete(t);
		return buscarTodos();
	}
	@PostMapping("/salvarTurma")
	public ModelAndView save(@Valid Turma turma, BindingResult result) {
		repository.saveAndFlush(turma);
		return buscarTodos();
	}

}
