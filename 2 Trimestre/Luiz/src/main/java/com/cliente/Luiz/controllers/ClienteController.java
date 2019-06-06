package com.cliente.Luiz.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cliente.Luiz.models.Cliente;
import com.cliente.Luiz.repository.ClienteRepository;

@Controller
public class ClienteController {

		@Autowired
		private ClienteRepository repository;

		@GetMapping("/cliente")
		public ModelAndView findAll() {
			
			ModelAndView mv = new ModelAndView("/clienteTabela");
			mv.addObject("clientes", repository.findAll());
			
			return mv;
		}
		
		@GetMapping("/addCliente")
		public ModelAndView add(Cliente cliente) {
			
			ModelAndView mv = new ModelAndView("/cadastrarCliente");
			mv.addObject("cliente",cliente);
			
			return mv;
		}
		
		@GetMapping("/editarCliente/{id}")
		public ModelAndView editar(@PathVariable("id") Long id) {
			Optional<Cliente> cliente = repository.findById(id);
			Cliente c = cliente.get();
			
			
			return add(c);
		}
		
		@GetMapping("/removerCliente/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			Optional<Cliente> cliente = repository.findById(id);
			Cliente c = cliente.get();
			repository.delete(c);
			
			return findAll();
		}
		
		@PostMapping("/salvarCliente")
		public ModelAndView save(@Valid Cliente cliente, BindingResult resultado) {
			
			repository.save(cliente);
			
			return findAll();
		}
	}
