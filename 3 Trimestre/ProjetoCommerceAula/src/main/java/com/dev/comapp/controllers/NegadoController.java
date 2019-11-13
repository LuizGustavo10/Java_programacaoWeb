package com.dev.comapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NegadoController {
	@GetMapping("/negado")
	public ModelAndView negado() {
		ModelAndView mv = new ModelAndView("/negado");
		return mv;
	}
}
