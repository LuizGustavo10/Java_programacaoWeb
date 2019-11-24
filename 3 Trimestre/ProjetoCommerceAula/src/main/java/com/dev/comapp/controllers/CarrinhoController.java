package com.dev.comapp.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Categoria;
import com.dev.comapp.models.Compra;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.ItensCompra;
import com.dev.comapp.models.Marca;
import com.dev.comapp.models.Produto;
import com.dev.comapp.repository.CategoriaRepository;
import com.dev.comapp.repository.MarcaRepository;
import com.dev.comapp.repository.ProdutoRepository;

@Controller
public class CarrinhoController {
	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	
	
	private Compra compra = new Compra();
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping("/loja")
	@ResponseBody
	public ModelAndView chamaLoja() {
		ModelAndView mv = new ModelAndView("/index");
		
		if (itensCompra == null) {
			mv.addObject("produtos", produtoRepository.findAll());
			System.out.println("nulo");
		} else {
			calcularTotal();
			mv.addObject("compra", compra);
			mv.addObject("listaItens", itensCompra);
			
			System.out.println(itensCompra.size());
			mv.addObject("produtos", produtoRepository.findAll());
		}
		
		return mv;
		
	}
	
	private void calcularTotal() {
		compra.setValorTotal(0.);
		for(ItensCompra it : itensCompra) {
			compra.setValorTotal(compra.getValorTotal() + it.getValorTotal());
		}
	}
	

	
	@GetMapping("/carrinho")
	@ResponseBody
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		calcularTotal();
		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
	
		
		return mv;
	}
	@GetMapping("/finalizar")
	public ModelAndView finalizarCompra() {
		ModelAndView mv = new ModelAndView("cliente/finalizar");
		calcularTotal();
		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
		return mv;
	}
	@GetMapping("/alterarQuantidade/{id}/{acao}")
	public String alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		for(ItensCompra it : itensCompra) {
			if(it.getProduto().getId().equals(id)) {
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade()+1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal()+(it.getQuantidade() * it.getValorUnitario()));
				}else if (acao == 0) {
					
					it.setQuantidade(it.getQuantidade()-1);
					it.setValorTotal(0.);
					it.setValorTotal(it.getValorTotal()+(it.getQuantidade() * it.getValorUnitario()));
				}
				break;
			}	
		}
		
		mv.addObject("listaItens", itensCompra);
		return "redirect:/carrinho";
	}
	@GetMapping("/removerProduto/{id}")
	public String removerProdutoCarrinho(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		for(ItensCompra it : itensCompra) {
			
			if(it.getProduto().getId().equals(id)) {
				
				itensCompra.remove(it);
				break;
			}	
		}
		
//		mv.addObject("listaItens", itensCompra);
		return "redirect:/carrinho";
	}
	
	@GetMapping("/adicionarCarrinho/{id}")
	
	public String adicionarCarrinho(@PathVariable Long id) { //1 incrementar, 0 diminuir qtde
		System.out.println(id);
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		Optional<Produto> prod = produtoRepository.findById(id);
		Produto produto = prod.get();
		
		//controlando quantidaed de um mesmo produto
		int controle = 0;
		for(ItensCompra it : itensCompra) {
			if(it.getProduto().getId().equals(produto.getId())) {
				it.setQuantidade(it.getQuantidade() + 1);
				it.setValorTotal(0.);
				it.setValorTotal(it.getValorTotal()+(it.getQuantidade() * it.getValorUnitario()));
				controle = 1;
				
				break;
			}
		}
		//se não foi adicionado ainda
		if (controle == 0) {
			ItensCompra item = new ItensCompra();
			item.setProduto(produto);
			item.setValorUnitario(produto.getPreco());
			item.setQuantidade(item.getQuantidade() + 1);
		
			item.setValorTotal(item.getValorTotal()+(item.getQuantidade() * item.getValorUnitario()));
			itensCompra.add(item);
		}
		
		
		
		mv.addObject("listaItens", itensCompra);
		
		return "redirect:/carrinho";
		
		
	}
}
