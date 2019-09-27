package com.dev.comapp.controllers;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.dev.comapp.models.Papel;

import com.dev.comapp.repository.PapelRepository;



@Controller
public class PapelController {
	
	@Autowired
	private PapelRepository repository;
	
	@GetMapping("administrativo/papel/papeis")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/papel/papelLista");
		mv.addObject("papeis", repository.findAll());
		
		return mv;
	}
	
//	@GetMapping("/papelNome")
//	public ModelAndView buscarNome(String nome) {
//		
//		ModelAndView mv = new ModelAndView("/papelLista");
//		mv.addObject("papeis", repository.buscarPorNome(nome));
//		
//		return mv;
//	}
	
	@GetMapping("/administrativo/papel/adicionarPapeis")
	public ModelAndView add(Papel papel) {
		
		ModelAndView mv = new ModelAndView("/administrativo/papel/papelAdicionar");
		mv.addObject("papel", papel);
		
		
		return mv;
	}
	
	@GetMapping("/administrativo/papel/editarPapeis/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Papel> papel = repository.findById(id);
		Papel e = papel.get();	
		
		return add(e);
	}
	
	@GetMapping("/administrativo/papel/removerPapeis/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Papel> papel = repository.findById(id);
		Papel e = papel.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/administrativo/papel/salvarPapeis")
	public ModelAndView save(@Valid Papel papel, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(papel);
		}
		
		repository.saveAndFlush(papel);
		
		return buscarTodos();
	}
	
}
