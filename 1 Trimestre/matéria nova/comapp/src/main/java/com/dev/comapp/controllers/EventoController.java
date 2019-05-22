package com.dev.comapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Convidado;
import com.dev.comapp.models.Evento;
import com.dev.comapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String eventos() {	
		
		return "evento/formEvento";
	}
	
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		eventoRepository.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping(value="/listaEventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("evento/listaEventos");
		List<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(value="/detalhesEvento/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") Long id) {
		Optional<Evento> evento = eventoRepository.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		Evento e=evento.get();
		mv.addObject("evento", e);
		return mv;
	}
	

}
