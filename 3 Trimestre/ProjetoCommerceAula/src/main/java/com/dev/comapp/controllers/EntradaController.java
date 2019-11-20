package com.dev.comapp.controllers;

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
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.models.Entrada;
import com.dev.comapp.models.Estado;
import com.dev.comapp.models.ItensEntrada;
import com.dev.comapp.models.Produto;
import com.dev.comapp.repository.EntradaRepository;
import com.dev.comapp.repository.EstadoRepository;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.ItensEntradaRepository;
import com.dev.comapp.repository.ProdutoRepository;

@Controller
public class EntradaController {
	private List<ItensEntrada> listaItensEntrada = new ArrayList<ItensEntrada>();
	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private ItensEntradaRepository itensEntradaRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("administrativo/entrada/entradas")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/entrada/entradaLista");
		mv.addObject("entradas", itensEntradaRepository.findAll());
		
		return mv;
	}
//	
//	@GetMapping("/administrativo/estado/estadosNome")
//	public ModelAndView buscarNome(String nome) {
//		
//		ModelAndView mv = new ModelAndView("administrativo/estado/estadoLista");
//		mv.addObject("estados", repository.buscarPorNome(nome));
//		
//		return mv;
//	}

	@GetMapping("/administrativo/entrada/adicionarEntrada")
	public ModelAndView add(Entrada entrada, ItensEntrada itensEntrada) {

		ModelAndView mv = new ModelAndView("/administrativo/entrada/entradaAdicionar");
		mv.addObject("entrada", entrada);
		// lista - itens de Entrada vai para dentro da lista, que vai ser exibido na tela
		mv.addObject("listaItensEntrada", this.listaItensEntrada);
		mv.addObject("itensEntrada", itensEntrada);
		mv.addObject("funcionarios", funcionarioRepository.findAll());
		mv.addObject("produtos", produtoRepository.findAll());

		return mv;
	}

//	@GetMapping("/administrativo/estado/editarEstado/{id}")
//	public ModelAndView edit(@PathVariable("id") Long id) {
//		
//		Optional<Estado> estado = repository.findById(id);
//		Estado e = estado.get();	
//		
//		return add(e);
//	}
//	
//	@GetMapping("/administrativo/estado/removerEstado/{id}")
//	public ModelAndView delete(@PathVariable("id") Long id) {
//		
//		Optional<Estado> estado = repository.findById(id);
//		Estado e = estado.get();
//		repository.delete(e);	
//		
//		return buscarTodos();
//	}

	@PostMapping("/administrativo/entrada/salvarEntrada")
	public ModelAndView save(String acao, Entrada entrada, ItensEntrada itensEntrada) {

		if (acao.equals("itens")) {
			this.listaItensEntrada.add(itensEntrada);
		}else if(acao.equals("salvar")){
			entradaRepository.saveAndFlush(entrada);
			for(ItensEntrada it : listaItensEntrada) {
				it.setEntrada(entrada);
				itensEntradaRepository.saveAndFlush(it);
				
				Optional<Produto> prod = produtoRepository.findById(it.getProduto().getId());
				Produto produto = prod.get();
				produto.setQtdeEstoque(produto.getQtdeEstoque() + it.getQuantidade());
				produto.setPreco(it.getValorVenda());
				produtoRepository.saveAndFlush(produto);
				this.listaItensEntrada = new ArrayList<>();
			}
			return add(new Entrada(), new ItensEntrada());
		}
		System.out.println(this.listaItensEntrada.size());

		return add(entrada, new ItensEntrada());
	}

}
