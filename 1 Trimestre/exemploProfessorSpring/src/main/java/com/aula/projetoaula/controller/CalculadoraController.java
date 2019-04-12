package com.aula.projetoaula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculadoraController {

	@RequestMapping("/calculadora")
	public String index() {
		return "index2";
	}
}
