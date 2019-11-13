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

import com.dev.comapp.models.Papel;
import com.dev.comapp.repository.AlunoRepository;
import com.dev.comapp.repository.PapelRepository;
import com.dev.comapp.repository.AlunoRepository;



@Controller
public class PapelController {
	
	@Autowired
	private PapelRepository repository;
	
	@GetMapping("/papeis")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/papelLista");
		java.util.List<Papel> lista =  repository.findAll();
		mv.addObject("obj", lista);		
		
		return mv;
	}

	
	@GetMapping("/adicionarPapel")
	public ModelAndView add(Papel obj) {
		
		ModelAndView mv = new ModelAndView("/papelAdicionar");
		mv.addObject("obj", obj);
		
		return mv;
	}
	
	@GetMapping("/editarPapel/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Papel> obj = repository.findById(id);
		Papel e = obj.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerPapel/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Papel> obj = repository.findById(id);
		Papel e = obj.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarPapel")
	public ModelAndView save(@Valid Papel obj, BindingResult result) {
		
		if(result.hasErrors() ){
			return add(obj);
		}
				
		repository.saveAndFlush(obj);
		
		return buscarTodos();
	}
	
}
