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

import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Categoria;
import com.dev.comapp.repository.CategoriaRepository;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriaRepository  repository;
	
	@GetMapping("administrativo/categoria/categorias")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/administrativo/categoria/categoriaLista");
		mv.addObject("categorias", repository.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/categoria/adicionarCategoria")
	public ModelAndView add(Categoria categoria) {
		ModelAndView mv = new ModelAndView("/administrativo/categoria/categoriaAdicionar");
		mv.addObject("categoria", categoria);
		return mv;
	}
	@GetMapping("/administrativo/categoria/editarCategoria/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();
		return add(e);
	}
	@GetMapping("/administrativo/categoria/removerCategoria/{id}")
	public ModelAndView delete(@PathVariable("id") Long id){
		Optional<Categoria> categoria = repository.findById(id);
		Categoria e = categoria.get();
		repository.delete(e);
		return buscarTodos();
	}
	@PostMapping("/administrativo/categoria/salvarCategoria")
	public ModelAndView save(@Valid Categoria categoria, BindingResult result){
		if(result.hasErrors()) {
			return add(categoria);
		}
		
		repository.saveAndFlush(categoria);
		
		return buscarTodos();
	}
}
