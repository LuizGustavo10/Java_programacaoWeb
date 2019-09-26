package com.dev.comapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@GetMapping("/administrativo")
	public String index() {
		return "administrativo/index";
	}
}


