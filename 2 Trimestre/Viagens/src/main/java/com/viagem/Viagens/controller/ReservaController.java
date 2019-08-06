package com.viagem.Viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.viagem.Viagens.models.Passageiro;
import com.viagem.Viagens.models.Reserva;
import com.viagem.Viagens.repository.PassageiroRepository;
import com.viagem.Viagens.repository.ReservaRepository;

@Controller
public class ReservaController {
	
	@Autowired
	private ReservaRepository repository;
	
	@Autowired
	private PassageiroRepository passageiroRepository;
	
	@GetMapping("/reserva")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/listaReserva");
		mv.addObject("reservas", repository.findAll());
		
		return mv;
	}
	
	@GetMapping("/addReserva")
	public ModelAndView add(Reserva reserva) {
		
		ModelAndView mv = new ModelAndView("/cadastrarReserva");

		mv.addObject("reserva", reserva);
		
		List <Passageiro> passageirosLista = passageiroRepository.findAll();
		mv.addObject("passageiros", passageirosLista);
		
		return mv;
	}
	
	@PostMapping("/buscarReserva")
	public ModelAndView buscarPorDestino(String destino) {
		
		ModelAndView mv = new ModelAndView("listaReserva");
		mv.addObject("reservas", repository.findByDestino(destino));
	
		return mv;
	}
	
	@GetMapping("/editarReserva/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Reserva> reserva = repository.findById(id);
		Reserva e = reserva.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerReserva/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Reserva> reserva = repository.findById(id);
		Reserva e = reserva.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarReserva")
	public ModelAndView save(@Valid Reserva reserva, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(reserva);
		}
		
		String dest = reserva.getDestino();
		if(dest.equals("Colômbia")) {
			reserva.setObservacao("Certificado Internacional de Vacinação");
		}
		if(dest.equals("República Dominicana")) {
			reserva.setObservacao("Certificado Internacional de Vacinação");
		}
		
		repository.saveAndFlush(reserva);
		
		return buscarTodos();
	}
	
}
