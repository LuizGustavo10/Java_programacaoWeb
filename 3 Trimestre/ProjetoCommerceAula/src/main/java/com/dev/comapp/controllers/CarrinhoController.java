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
	
	public List getItensCompra() {
		return itensCompra;
	}
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/carrinho")
	@ResponseBody
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		mv.addObject("listaItens", itensCompra);
		return mv;
	}
	@GetMapping("/alterarQuantidade/{id}/{acao}")
	public ModelAndView alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		for(ItensCompra it : itensCompra) {
			if(it.getProduto().getId().equals(id)) {
				if (acao.equals(1)) {
					it.setQuantidade(it.getQuantidade()+1);
				}else if (acao == 0) {
					it.setQuantidade(it.getQuantidade()-1);
				}
				break;
			}	
		}
		
		mv.addObject("listaItens", itensCompra);
		return mv;
	}
	@GetMapping("/removerProduto/{id}")
	public ModelAndView removerProdutoCarrinho(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		for(ItensCompra it : itensCompra) {
			if(it.getProduto().getId().equals(id)) {
				
				itensCompra.remove(it);
				break;
			}	
		}
		
		mv.addObject("listaItens", itensCompra);
		return mv;
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
				controle = 1;
				it.setQuantidade(it.getQuantidade() + 1);
				break;
			}
		}
		//se não foi adicionado ainda
		if (controle == 0) {
			ItensCompra item = new ItensCompra();
			item.setProduto(produto);
			item.setValorUnitario(produto.getPreco());
			item.setQuantidade(item.getQuantidade() + 1);
			item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
			itensCompra.add(item);
		}
		
		
		
		mv.addObject("listaItens", itensCompra);
		return "redirect:/carrinho";
		
		
	}
}
