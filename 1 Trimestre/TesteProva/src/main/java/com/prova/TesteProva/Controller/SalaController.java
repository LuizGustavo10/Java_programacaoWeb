package com.prova.TesteProva.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prova.TesteProva.Local.Local;

@Controller
public class SalaController {
	@RequestMapping("/consultaSala")
	public String consultar() {
		return "sala";
	}
	
	@RequestMapping(value="/consultarAgora", method=RequestMethod.POST)
	public ModelAndView analisarDados(Local local) {
		ModelAndView viewRetorno = new ModelAndView("resultados");//pagina que é para carregar
		viewRetorno.addObject("nome", local.getNome());
		viewRetorno.addObject("numSala",local.getSala());
	
		return viewRetorno;
		
	}
}
