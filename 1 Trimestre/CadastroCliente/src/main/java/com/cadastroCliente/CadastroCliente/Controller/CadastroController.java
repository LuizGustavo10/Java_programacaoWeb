package com.cadastroCliente.CadastroCliente.Controller;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cadastroCliente.CadastroCliente.Models.Local;

@Controller
public class CadastroController {
	@RequestMapping(value ="/executarConsulta", method=RequestMethod.POST)
	public ModelAndView exibir(Local local) {
		ModelAndView viewRetorno = new ModelAndView("cadastroClientes");
		viewRetorno.addObject("local", local);
		

	return viewRetorno;
	}
//	@RequestMapping(value="/executarConsulta", method=RequestMethod.POST)
//	public String form() {
//		return "redirect:/cadastroClientes";
//	}
	
}
