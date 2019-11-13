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

import com.dev.comapp.models.AlunoTurma;
import com.dev.comapp.models.Turma;
import com.dev.comapp.repository.AlunoTurmaRepository;
import com.dev.comapp.repository.TurmaRepository;
import com.dev.comapp.repository.TurmaRepository;

@Controller
public class TurmaController {

	@Autowired
	private TurmaRepository repository;
	
	@Autowired
	private AlunoTurmaRepository alunoTurmarepository;

	@GetMapping("/turmas")
	public ModelAndView buscarTodos() {

		ModelAndView mv = new ModelAndView("/turmasLista");
		mv.addObject("turmas", repository.findAll());

		return mv;
	}

	@GetMapping("/addTurma")
	public ModelAndView add(Turma categoria) {

		ModelAndView mv = new ModelAndView("/turmaAdd");
		mv.addObject("turma", categoria);

		return mv;
	}
	
	@GetMapping("/listarAlunosTurma/{id}")
	public ModelAndView buscarAlunosTurma(@PathVariable("id") Long id) {

		List<AlunoTurma> lat = alunoTurmarepository.buscarPorTurma(id);
		ModelAndView mv = new ModelAndView("/turmasListaAlunos");
		if(lat.size()>0) {
			mv.addObject("descricaoTurma","Turma: "+lat.get(0).getTurma().getDescricao());
		}else {
			Optional<Turma> turma = repository.findById(id);
			Turma e = turma.get();
			mv.addObject("descricaoTurma","A turma "+e.getDescricao()+" não tem inscritos!!");
		}
		
		mv.addObject("listaAlunosTurma", lat);

		return mv;
	}

	@GetMapping("/editarTurma/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		Optional<Turma> categoria = repository.findById(id);
		Turma e = categoria.get();

		return add(e);
	}

	@GetMapping("/removerTurma/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		Optional<Turma> categoria = repository.findById(id);
		Turma e = categoria.get();
		repository.delete(e);

		return buscarTodos();
	}

	@PostMapping("/salvarTurma")
	public ModelAndView save(@Valid Turma turma, BindingResult result) {

//		if (result.hasErrors() || turma.getQuantidadeVagas() < 10 
//				|| turma.getQuantidadeVagas() > 50) {
//			return add(turma);
//		}

		repository.saveAndFlush(turma);

		return buscarTodos();
	}

}
