package com.dev.comapp.controllers;

import java.util.List;
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


import com.dev.comapp.models.Cliente;
import com.dev.comapp.models.Compra;
import com.dev.comapp.models.Estado;
import com.dev.comapp.repository.CidadeRepository;
import com.dev.comapp.repository.ClienteRepository;
import com.dev.comapp.repository.EstadoRepository;



@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	private Compra compra = new Compra();
	
	@GetMapping("/cliente/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/cadastrar");
		mv.addObject("compra", compra);
		mv.addObject("cliente", cliente);
		mv.addObject("cidades", cidadeRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cliente/editarCliente/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Cliente> cliente = repository.findById(id);
		return cadastrar(cliente.get());
	}
	


	@PostMapping("/cliente/salvarCliente")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		
		if(result.hasErrors()) {
			return cadastrar(cliente);
		}
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		repository.saveAndFlush(cliente);
		
		return cadastrar(new Cliente());
	}
	
}
