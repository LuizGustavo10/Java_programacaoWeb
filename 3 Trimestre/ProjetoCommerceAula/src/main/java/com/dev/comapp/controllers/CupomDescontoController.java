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

import com.dev.comapp.models.CupomDesconto;
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.repository.CupomDescontoRepository;
import com.dev.comapp.repository.FuncionarioRepository;

@Controller
public class CupomDescontoController {
	@Autowired
	private CupomDescontoRepository repository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/cuponsDes")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/cupomDescontoLista");
		mv.addObject("cuponsDesconto", repository.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarCupomDes")
	public ModelAndView add(CupomDesconto cupomDesconto) {
		ModelAndView mv = new ModelAndView("/cupomDescontoAdicionar");
		mv.addObject("cupomDesconto", cupomDesconto);
		
		List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();
		mv.addObject("funcionarios", listaFuncionarios);
		return mv;
	}
	
	@GetMapping("/editarCupomDes/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<CupomDesconto> cupomDesconto = repository.findById(id);
		CupomDesconto c = cupomDesconto.get();
		return add(c);
	}
	@GetMapping("/removerCupomDes/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<CupomDesconto> cupomDesconto = repository.findById(id);
		CupomDesconto c = cupomDesconto.get();
		repository.delete(c);
		return buscarTodos();
	}
	@PostMapping("/salvarCupomDes")
	public ModelAndView save(@Valid CupomDesconto cupomDesconto, BindingResult result){
		if(result.hasErrors()) {
			return add(cupomDesconto);
		}
		repository.saveAndFlush(cupomDesconto);
		return buscarTodos();
	}
	
	
}
