package com.dev.comapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens_entrada")
public class ItensEntrada {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Entrada entrada;
	@ManyToOne
	private Produto produto;
	private Double quantidade = 0.;
	private Double valorProduto = 0.;
	private Double valorVenda = 0.;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	
}
