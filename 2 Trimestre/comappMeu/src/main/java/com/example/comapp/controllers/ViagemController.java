package com.example.comapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.comapp.models.Cliente;
import com.example.comapp.repository.ClienteRepository;


@Controller
public class ViagemController {

	@Autowired
	private ClienteRepository ClienteRepository;

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String Clientes() {	
		
		return "tabela";
	}


	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(Cliente cli) {
		if(cli.getPeso() > 10 || cli.getAltura() > 55 || cli.getLargura() > 35 || cli.getComprimento() > 25){
			String tipo = cli.getTipoVoo();
//			alert("Mala terá que ser despachada! \n voos domésticos: USD R$35 / R$140 \n voos internacionais: USD 70 / R$ 280");
			if (tipo.equals("nacional")) {
				cli.setValorAdicional("R$35 / R$ 140");
			}else {
				cli.setValorAdicional("R$70 / R$ 280");
			}
			System.out.println("blz");
					
		}
		
		ClienteRepository.save(cli);
		
		return "redirect:/listaClientes";
		
	}

		
	
	
	@RequestMapping(value="/listaClientes")//aqui é /listaClientes
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("tabela");
		List<Cliente> clientes = ClienteRepository.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="/detalhesCliente/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesCliente(@PathVariable("codigo") Long id) {
		Optional<Cliente> Cliente = ClienteRepository.findById(id);
		ModelAndView mv = new ModelAndView("Cliente/detalhesCliente");
		Cliente e=Cliente.get();
		mv.addObject("Cliente", e);
		return mv;
	}
	

}
