package com.aula.projetoaula.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aula.projetoaula.models.LocalProva;

@Controller
public class ConsultaSalaController {

	@RequestMapping("/consultaSala")
	public String consultaSala() {
		return "consulta-sala";
	}

	@RequestMapping(value = "/consultarSala", method = RequestMethod.POST)
	public ModelAndView consultarSala(LocalProva local) {
		ModelAndView viewRetorno  = new ModelAndView("consulta-sala");
		viewRetorno.addObject("nomeAluno", local.getNome());
		int sala = 0;
		if (local.getCurso().equals("técnico em informática")) {
			sala = 22;
		}
		viewRetorno.addObject("sala", sala);
		return viewRetorno;
	}
}
