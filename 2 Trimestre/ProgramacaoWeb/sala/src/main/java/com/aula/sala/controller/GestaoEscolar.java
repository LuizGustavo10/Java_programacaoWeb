package com.aula.sala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class GestaoEscolar {
	
	@RequestMapping(value = "analisar", method = RequestMethod.POST)
	public ModelAndView verificar(String nome) {
		ModelAndView mv = new ModelAndView("index");
		String name = nome;
		
		mv.addObject("nome", name);
		return mv;
	}
	
	
}
