package com.sala.SeletorDeSala.Controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sala.SeletorDeSala.Models.LocalProva;



@Controller
//Primeira requisição, pagina principal direciona para consulta-sala
public class ConsultarSalaController {
	@RequestMapping("/consultaPrincipal")
	public String consultaSala() {
		return "consulta-sala";
	}
	@RequestMapping(value ="/executarConsulta", method=RequestMethod.POST)
	public ModelAndView consultarSala(LocalProva local) {
		ModelAndView viewRetorno = new ModelAndView("consulta-sala");
		viewRetorno.addObject("nomeAluno", local.getNome());
		int sala = 0;
		if(local.getCurso().equals("Técnico em informática")) {
			sala = 22;
			
		}else if(local.getCurso().equals("técnico em alimentos")) {
			sala = 21;
		}else if(local.getCurso().equals("técnico em agropecuária")) {
			char primeiraLetra= local.getNome().charAt(0);//guardando em variavel primeira letra do nome
			if(primeiraLetra >= 'a'&& primeiraLetra <= 'k') {
				sala=11;
			}else if(primeiraLetra >= 'l' && primeiraLetra <= 'n') {
				sala=12;
			}else if(primeiraLetra >= 'o' && primeiraLetra <= 'z') {
				sala=13;
			}
			
			
		}
		viewRetorno.addObject("sala",sala);
		return viewRetorno;
		
	}
}
