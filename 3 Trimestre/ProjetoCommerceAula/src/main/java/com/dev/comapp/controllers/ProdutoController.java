package com.dev.comapp.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Produto;
import com.dev.comapp.repository.ProdutoRepository;

public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("administrativo/produto/produtos")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/administrativo/produtos/produtoLista");
		mv.addObject("produtos", repository.findAll());
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
		Produto p = produto.get();
		return add(p);
	}
	@GetMapping("/administrativo/produto/removerProduto/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<Produto> produto = repository.findById(id);
		Produto p = produto.get();
		repository.delete(p);
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
