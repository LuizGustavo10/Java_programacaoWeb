package com.example.comapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {
	
	@RequestMapping("/nada")
	public String index() {
		return "index";
	}
}


