package com.dev.comapp.controllers;

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

import com.dev.comapp.models.Cidade;
import com.dev.comapp.models.CupomDesconto;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.PermissoesFuncionario;
import com.dev.comapp.models.PermissoesPermissoesFuncionario;
import com.dev.comapp.repository.PermissoesFuncionarioRepository;
import com.dev.comapp.repository.PapelRepository;
import com.dev.comapp.repository.CidadeRepository;
import com.dev.comapp.repository.CupomDescontoRepository;
import com.dev.comapp.repository.FuncionarioRepository;



@Controller
public class PermissoesFuncionarioController {
	
	@Autowired
	private PermissoesFuncionarioRepository repository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	

	
	@GetMapping("/permissoesFuncionarios")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/permissoesFuncionarioLista");
		java.util.List<PermissoesFuncionario> listaPermissoesFuncionarios =  repository.findAll();
		mv.addObject("permissoesFuncionarios", listaPermissoesFuncionarios);
		mv.addObject("quantidadePermissoesFuncionarios", listaPermissoesFuncionarios.size());
		
		return mv;
	}
	
//	//BUSCAR ALUNO POR NOME
//	@GetMapping("/buscarPermissoesFuncionarioNome")
//	public ModelAndView buscarPermissoesFuncionarios(String nome) {		
//		ModelAndView mv = new ModelAndView("/permissoesFuncionarioLista");
//		mv.addObject("permissoesFuncionarios", repository.buscarPorNome(nome));		
//		return mv;
//	}
	
	
	
	
	
	
	@GetMapping("/adicionarPermissoesFuncionario")
	public ModelAndView add(PermissoesFuncionario categoria) {
		
		
		ModelAndView mv = new ModelAndView("/permissoesFuncionarioAdd");
		mv.addObject("permissoesFuncionario", categoria);
		List<Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades",listaCidade);
		List<CupomDesconto> listaCuponsDesconto = cupomDescontoRepository.findAll();
		mv.addObject("cuponsDesconto", listaCuponsDesconto);
		
		return mv;
	}
	
	@GetMapping("/editarPermissoesFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> categoria = repository.findById(id);
		PermissoesFuncionario e = categoria.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerPermissoesFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> categoria = repository.findById(id);
		PermissoesFuncionario e = categoria.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarPermissoesFuncionario")
	public ModelAndView save(@Valid PermissoesFuncionario permissoesFuncionario, BindingResult result) {
		
//		if(result.hasErrors()  || !permissoesFuncionario.getCpf().equals(11)) {
//			return add(permissoesFuncionario);
//		}
		
		repository.saveAndFlush(permissoesFuncionario);
		
		return buscarTodos();
	}
	
}
