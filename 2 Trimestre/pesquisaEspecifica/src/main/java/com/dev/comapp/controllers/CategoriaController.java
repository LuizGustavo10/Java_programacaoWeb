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

import com.dev.comapp.models.Categoria;
import com.dev.comapp.repository.CategoriaRepository;



@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/categoria")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/categoriaPost");
		mv.addObject("categorias", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/addCategoria")
	public ModelAndView add(Categoria categoria) {
		
		ModelAndView mv = new ModelAndView("/categoriaAdd");
		mv.addObject("categoria", categoria);
		
		return mv;
	}
	
	@GetMapping("/editarCategoria/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerCategoria/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarCategoria")
	public ModelAndView save(@Valid Categoria categoria, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(categoria);
		}
		
		repository.saveAndFlush(categoria);
		
		return buscarTodos();
	}
	
}
