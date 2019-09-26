package com.dev.comapp.models;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CupomDesconto implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String nome;
	private Long porcentagem;
	@ManyToOne
	private Funcionario funcionario;

			
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(Long porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	
	
	
			

	
	
}
