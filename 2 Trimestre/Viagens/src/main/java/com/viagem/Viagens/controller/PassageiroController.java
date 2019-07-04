package com.viagem.Viagens.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.viagem.Viagens.models.Passageiro;
import com.viagem.Viagens.repository.PassageiroRepository;

@Controller
public class PassageiroController {
	
	@Autowired
	private PassageiroRepository repository;
	
	@GetMapping("/passageiro")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/listaPassageiro");
		mv.addObject("passageiros", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/addPassageiro")
	public ModelAndView add(Passageiro passageiro) {
		
		ModelAndView mv = new ModelAndView("/cadastrarPassageiro");
		mv.addObject("passageiro", passageiro);
		
		return mv;
	}
	
	@GetMapping("/editarPassageiro/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Passageiro> passageiro = repository.findById(id);
		Passageiro e = passageiro.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerPassageiro/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Passageiro> passageiro = repository.findById(id);
		Passageiro e = passageiro.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarPassageiro")
	public ModelAndView save(@Valid Passageiro passageiro, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(passageiro);
		}
		
		repository.saveAndFlush(passageiro);
		
		return buscarTodos();
	}
	
}
