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

import com.dev.comapp.models.Categoria;
import com.dev.comapp.models.Cidade;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.repository.CategoriaRepository;
import com.dev.comapp.repository.CidadeRepository;
import com.dev.comapp.repository.EstadoRepository;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.PapelRepository;
import com.dev.comapp.repository.PermissoesFuncionarioRepository;



@Controller
public class CidadeController {
	
	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private EstadoRepository repositoryEstado;
	

	@GetMapping("/cidades")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/cidadeLista");
		mv.addObject("cidades", repository.findAll());
				
		
		return mv;
	}
	
	@GetMapping("/adicionarCidade")
	public ModelAndView add(Cidade cidade) {
		
		ModelAndView mv = new ModelAndView("/cidadeAdicionar");
		mv.addObject("cidade", cidade);
		
		List<Estado> listaEstado = repositoryEstado.findAll();
		mv.addObject("estados",listaEstado);
		
		return mv;
	}
	
	@GetMapping("/editarCidade/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = repository.findById(id);
		Cidade e = cidade.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerCidade/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Cidade> cidade = repository.findById(id);
		Cidade e = cidade.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarCidade")
	public ModelAndView save(@Valid Cidade cidade, BindingResult result) {
		
		
		if(result.hasErrors()) {
			return add(cidade);
		}
		
		repository.saveAndFlush(cidade);
		
		return buscarTodos();
	}
	
}
