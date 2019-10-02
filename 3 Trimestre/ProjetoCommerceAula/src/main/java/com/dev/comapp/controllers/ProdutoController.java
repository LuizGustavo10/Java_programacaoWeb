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


import com.dev.comapp.models.Produto;

import com.dev.comapp.repository.ProdutoRepository;



@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("administrativo/produto/produtos")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/produto/produtoLista");
		mv.addObject("produtos", repository.findAll());
		
		return mv;
	}
	@GetMapping("index")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("produtos", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/administrativo/produto/produtosNome")
	public ModelAndView buscarNome(String nome) {
		
		ModelAndView mv = new ModelAndView("administrativo/produto/produtoLista");
		mv.addObject("produtos", repository.buscarPorNome(nome));
		
		return mv;
	}
	
	@GetMapping("/administrativo/produto/adicionarProduto")
	public ModelAndView add(Produto produto) {
		
		ModelAndView mv = new ModelAndView("/administrativo/produto/produtoAdicionar");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	@GetMapping("/administrativo/produto/editarProduto/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = repository.findById(id);
		Produto e = produto.get();	
		
		return add(e);
	}
	
	@GetMapping("/administrativo/produto/removerProduto/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Produto> produto = repository.findById(id);
		Produto e = produto.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/administrativo/produto/salvarProduto")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(produto);
		}
		
		repository.saveAndFlush(produto);
		
		return buscarTodos();
	}
	
}
