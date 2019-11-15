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

import com.dev.comapp.models.Entrada;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.ItensEntrada;
import com.dev.comapp.repository.EntradaRepository;
import com.dev.comapp.repository.EstadoRepository;
import com.dev.comapp.repository.ItensEntradaRepository;

@Controller
public class EntradaController {

	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private ItensEntradaRepository itensEntradaRepository;

//	@GetMapping("administrativo/entrada/estados")
//	public ModelAndView buscarTodos() {
//		
//		ModelAndView mv = new ModelAndView("/administrativo/estado/estadoLista");
//		mv.addObject("estados", repository.findAll());
//		
//		return mv;
//	}
//	
//	@GetMapping("/administrativo/estado/estadosNome")
//	public ModelAndView buscarNome(String nome) {
//		
//		ModelAndView mv = new ModelAndView("administrativo/estado/estadoLista");
//		mv.addObject("estados", repository.buscarPorNome(nome));
//		
//		return mv;
//	}

	@GetMapping("/administrativo/entrada/adicionarEntrada")
	public ModelAndView add(Entrada entrada, List<ItensEntrada> listaItensEntrada, ItensEntrada itensEntrada) {

		ModelAndView mv = new ModelAndView("/administrativo/entrada/entradaAdicionar");
		mv.addObject("entrada", entrada);
		// lista - itens de Entrada vai para dentro da lista, que vai ser exibido na tela
		mv.addObject("listaItensEntrada", listaItensEntrada);
		mv.addObject("itensEntrada", itensEntrada);

		return mv;
	}

//	@GetMapping("/administrativo/estado/editarEstado/{id}")
//	public ModelAndView edit(@PathVariable("id") Long id) {
//		
//		Optional<Estado> estado = repository.findById(id);
//		Estado e = estado.get();	
//		
//		return add(e);
//	}
//	
//	@GetMapping("/administrativo/estado/removerEstado/{id}")
//	public ModelAndView delete(@PathVariable("id") Long id) {
//		
//		Optional<Estado> estado = repository.findById(id);
//		Estado e = estado.get();
//		repository.delete(e);	
//		
//		return buscarTodos();
//	}

	@PostMapping("/administrativo/entrada/salvarEntrada")
	public ModelAndView save(String acao, Entrada entrada, List<ItensEntrada> listaItensEntrada, ItensEntrada itensEntrada) {

		if (acao.equals("itens")) {
			listaItensEntrada.add(itensEntrada);
		}
		System.out.println(listaItensEntrada.size());

		return add(entrada, listaItensEntrada, new ItensEntrada());
	}

}