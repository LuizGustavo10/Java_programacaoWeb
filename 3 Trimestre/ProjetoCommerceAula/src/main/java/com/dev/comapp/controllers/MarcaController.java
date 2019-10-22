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
import com.dev.comapp.models.Marca;
import com.dev.comapp.repository.MarcaRepository;

@Controller
public class MarcaController {
	@Autowired
	private MarcaRepository  repository;
	
	@GetMapping("administrativo/marca/marcas")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/administrativo/marca/marcaLista");
		mv.addObject("marcas", repository.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/marca/adicionarMarca")
	public ModelAndView add(Marca marca) {
		ModelAndView mv = new ModelAndView("/administrativo/marca/marcaAdicionar");
		mv.addObject("marca", marca);
		return mv;
	}
	@GetMapping("/administrativo/marca/editarMarca/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		Optional<Marca> marca = repository.findById(id);
		Marca e = marca.get();
		return add(e);
	}
	@GetMapping("/administrativo/marca/removerMarca/{id}")
	public ModelAndView delete(@PathVariable("id") Long id){
		Optional<Marca> marca = repository.findById(id);
		Marca e = marca.get();
		repository.delete(e);
		return buscarTodos();
	}
	@PostMapping("/administrativo/marca/salvarMarca")
	public ModelAndView save(@Valid Marca marca, BindingResult result){
		if(result.hasErrors()) {
			return add(marca);
		}
		
		repository.saveAndFlush(marca);
		
		return buscarTodos();
	}
}
