package com.example.comapp.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.comapp.models.Cliente;
import com.example.comapp.repository.ClienteRepository;


@Controller
public class ViagemController {

	@Autowired
	private ClienteRepository ClienteRepository;

	@GetMapping("/clientes")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("tabela");
		mv.addObject("clientes", ClienteRepository.findAll());
		return mv;
	}


//	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
//	public String form(Cliente cli) {
//		if(cli.getPeso() > 10 || cli.getAltura() > 55 || cli.getLargura() > 35 || cli.getComprimento() > 25){
//			String tipo = cli.getTipoVoo();
////			alert("Mala terá que ser despachada! \n voos domésticos: USD R$35 / R$140 \n voos internacionais: USD 70 / R$ 280");
//			if (tipo.equals("nacional")) {
//				cli.setValorAdicional("R$35 / R$ 140");
//			}else {
//				cli.setValorAdicional("R$70 / R$ 280");
//			}
//			System.out.println("blz");
//					
//		}
//		
//		ClienteRepository.save(cli);
//		
//		return "redirect:/listaClientes";
//		
//	}
	@GetMapping("/cadastrarCliente")
	public ModelAndView cadastrarCliente(Cliente cliente) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cliente", cliente);
		return mv;
	}
	@GetMapping("/editarCliente/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = ClienteRepository.findById(id);
		Cliente e = cliente.get();
		return cadastrarCliente(e);
	}
	@GetMapping("/removerCliente/{id}")
	public ModelAndView delete(@PathVariable("id")Long id) {
		Optional<Cliente> cliente = ClienteRepository.findById(id);
		Cliente e = cliente.get();
		ClienteRepository.delete(e);
		return findAll();
	}
	
	
	@PostMapping("/salvarCliente")
	public ModelAndView salvarCliente(@Valid Cliente cli, BindingResult result) { //BindingResult result, colocar para verificar erro
		
		if(cli.getPeso() > 10 || cli.getAltura() > 55 || cli.getLargura() > 35 || cli.getComprimento() > 25){
		String tipo = cli.getTipoVoo();
//		alert("Mala terá que ser despachada! \n voos domésticos: USD R$35 / R$140 \n voos internacionais: USD 70 / R$ 280");
		if (tipo.equals("nacional")) {
			cli.setValorAdicional("R$35 / R$ 140");
		}else {
			cli.setValorAdicional("R$70 / R$ 280");
		}
		}

		ClienteRepository.saveAndFlush(cli);
		return findAll();
		
		}

		
	
	
	@GetMapping("/listaClientes")//aqui é /listaClientes
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("tabela");
		List<Cliente> clientes = ClienteRepository.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	

}
