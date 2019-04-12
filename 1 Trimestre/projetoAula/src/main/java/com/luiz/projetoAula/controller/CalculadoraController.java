package com.luiz.projetoAula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {
		@RequestMapping(value ="/calcular", method = RequestMethod.POST)
		public ModelAndView somar(Double v1, Double v2) {
			ModelAndView mv = new ModelAndView("Calculadora");
			Double resultado = v1 + v2;
			System.out.println(resultado);
			mv.addObject("resultado", resultado);
			return mv;
	}
}

