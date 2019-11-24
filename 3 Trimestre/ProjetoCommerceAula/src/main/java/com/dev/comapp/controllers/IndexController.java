package com.dev.comapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.ItensCompra;

import com.dev.comapp.controllers.CarrinhoController;
import com.dev.comapp.repository.ProdutoRepository;

@Controller
public class IndexController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();//pegar lista de outra classe
	
//	 car.getItensCompra();
	
	
	
	@GetMapping("/")
	public String index() {
		return "administrativo/index";
	}
	@GetMapping("/administrativo")
	public String index2() {
		return "administrativo/index";
	}
}


