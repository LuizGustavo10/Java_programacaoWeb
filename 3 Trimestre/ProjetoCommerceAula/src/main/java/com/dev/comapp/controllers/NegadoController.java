package com.dev.comapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NegadoController {
	//administrativo
	@GetMapping("/negado")
	public ModelAndView negado() {
		ModelAndView mv = new ModelAndView("/negado");
		return mv;
	}
	@GetMapping("/negadoCliente")
	public ModelAndView negadoCliente() {
		ModelAndView mv = new ModelAndView("/negadoCliente");
		return mv;
	}
	
}
