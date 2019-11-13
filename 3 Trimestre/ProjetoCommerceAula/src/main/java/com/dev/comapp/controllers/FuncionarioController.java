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

import com.dev.comapp.models.Cidade;
import com.dev.comapp.models.CupomDesconto;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.CidadeRepository;
import com.dev.comapp.repository.CupomDescontoRepository;



@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CupomDescontoRepository cupomDescontoRepository;
	
	@GetMapping("administrativo/funcionario/funcionarios")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/funcionario/funcionarioLista");
		java.util.List<Funcionario> listaFuncionarios =  repository.findAll();
		mv.addObject("funcionarios", listaFuncionarios);
		mv.addObject("quantidadeFuncionarios", listaFuncionarios.size());
		
		return mv;
	}
	
//	//BUSCAR ALUNO POR NOME
//	@GetMapping("/buscarFuncionarioNome")
//	public ModelAndView buscarFuncionarios(String nome) {		
//		ModelAndView mv = new ModelAndView("/funcionarioLista");
//		mv.addObject("funcionarios", repository.buscarPorNome(nome));		
//		return mv;
//	}
	
	
	
	
	
	
	@GetMapping("/administrativo/funcionario/adicionarFuncionario")
	public ModelAndView add(Funcionario categoria) {
		
		
		ModelAndView mv = new ModelAndView("/administrativo/funcionario/funcionarioAdicionar");
		mv.addObject("funcionario", categoria);
		List<Cidade> listaCidade = cidadeRepository.findAll();
		mv.addObject("cidades",listaCidade);
		

		
		return mv;
	}
	
	@GetMapping("/administrativo/funcionario/editarFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Funcionario> categoria = repository.findById(id);
		Funcionario e = categoria.get();	
		
		return add(e);
	}
	
	@GetMapping("/administrativo/funcionario/removerFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Funcionario> categoria = repository.findById(id);
		Funcionario e = categoria.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/administrativo/funcionario/salvarFuncionario")
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult result) {
		
//		if(result.hasErrors()  || !funcionario.getCpf().equals(11)) {
//			return add(funcionario);
//		}
		funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
		repository.saveAndFlush(funcionario);
		
		return buscarTodos();
	}
	
}
