package com.dev.comapp.controllers;

import java.util.ArrayList;
import java.util.Date;
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

import com.dev.comapp.models.Categoria;
import com.dev.comapp.models.ItensVenda;
import com.dev.comapp.models.Venda;
import com.dev.comapp.repository.CategoriaRepository;
import com.dev.comapp.repository.ItensVendaRepository;
import com.dev.comapp.repository.VendaRepository;

@Controller
public class VendaController {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItensVendaRepository itensVendaRepository;

	private Venda venda = new Venda();
	private ItensVenda itensVenda = new ItensVenda();
	private List<ItensVenda> listaItensVenda = new ArrayList<>();

	// @GetMapping("/categoria")
	// public ModelAndView buscarTodos() {
	//
	// ModelAndView mv = new ModelAndView("/categoriaPost");
	// mv.addObject("categorias", repository.findAll());
	//
	// return mv;
	// }

	@GetMapping("/addVenda")
	public ModelAndView add() {

		ModelAndView mv = new ModelAndView("/vendaAdd");
		mv.addObject("venda", this.venda);
		mv.addObject("itensVenda", this.itensVenda);

		return mv;
	}

	// @GetMapping("/editarCategoria/{id}")
	// public ModelAndView edit(@PathVariable("id") Long id) {
	//
	// Optional<Categoria> categoria = repository.findById(id);
	// Categoria e = categoria.get();
	//
	// return add(e);
	// }

	// @GetMapping("/removerCategoria/{id}")
	// public ModelAndView delete(@PathVariable("id") Long id) {
	//
	// Optional<Categoria> categoria = repository.findById(id);
	// Categoria e = categoria.get();
	// repository.delete(e);
	//
	// return buscarTodos();
	// }

	@PostMapping("/inserirSalvarVenda")
	public ModelAndView save(@Valid Venda venda, 
			@Valid ItensVenda itensVenda, BindingResult result, 
			String acao) {

		// if(result.hasErrors()) {
		// return add(categoria);
		// }
		this.venda = venda;

		if (acao.equals("item")) {
			listaItensVenda.add(itensVenda);
		} else if (acao.equals("salvar")) {
			// SALVAR A VENDA NO BANCO DE DADOS....
			this.venda.setDataVenda(new Date());
			vendaRepository.saveAndFlush(this.venda);
			for (ItensVenda it : listaItensVenda) {
				it.setVenda(this.venda);
				itensVendaRepository.saveAndFlush(it);
			}
			this.venda = new Venda();
			this.listaItensVenda = new ArrayList<>();
		}

		System.out.println("Quantidade Itens: " + listaItensVenda.size());
		System.out.println(this.venda.getObservacao());
		System.out.println(itensVenda.getQuantidade());
		return add();
	}

}
