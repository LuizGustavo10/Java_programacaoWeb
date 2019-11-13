package com.dev.comapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SituacaoController {

	@RequestMapping("/pagina-situacao")
	public String calculadora() {
		
		return "situacao";
	}

	@RequestMapping(value = "/verificar", method = RequestMethod.POST)
	public ModelAndView somar(Double n1, Double n2, Double n3, Double n4) {
		ModelAndView mv = new ModelAndView("situacao");
		Double media = (n1 + n2 + n3 + n4) / 4;
		String situacaoRetorno = "Aprovado";
		if (media < 6) {
			situacaoRetorno = "Reprovado";
		}
		mv.addObject("situacao", situacaoRetorno);
		return mv;
	}
}
