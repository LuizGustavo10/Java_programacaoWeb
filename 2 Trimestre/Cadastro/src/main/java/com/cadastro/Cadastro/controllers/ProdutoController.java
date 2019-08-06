package com.cadastro.Cadastro.controllers;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.Cadastro.models.Produto;
import com.cadastro.Cadastro.repository.ProdutoRepository;




@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produto")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/produtoPost");
		mv.addObject("produtos", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/addProduto")
	public ModelAndView add(Produto produto) {
		
		ModelAndView mv = new ModelAndView("/produtoAdd");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = repository.findById(id);
		Produto e = produto.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerProduto/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = repository.findById(id);
		Produto e = produto.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarProduto")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(produto);
		}
		
		repository.saveAndFlush(produto);
		
		return buscarTodos();
	}
	
}
