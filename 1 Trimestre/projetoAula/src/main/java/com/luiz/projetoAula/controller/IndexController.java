package com.luiz.projetoAula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
//		return "index"; //essa é do olá mundo;
		return "Calculadora";
	}
}