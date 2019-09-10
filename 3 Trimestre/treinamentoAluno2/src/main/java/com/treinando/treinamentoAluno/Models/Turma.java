package com.treinando.treinamentoAluno.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
@Entity(name="turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message ="A descrição da turma é obrigatória")
	private String descricao;
	private Integer quantidadeDeVagas;
//	@Temporal(TemporalType.DATE)
	private String dataCadastro;
	private Integer vagasRestantes=-1;
	
	
	private Integer ano;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
//	public Integer getQuantidadeDeVagas() {
//		return quantidadeDeVagas;
//	}
//	public void setQuantidadeDeVagas(Integer quantidadeDeVagas) {
//		this.quantidadeDeVagas = quantidadeDeVagas;
//	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
//	public Integer getVagasRestantes() {
//		return vagasRestantes;
//	}
//	public void setVagasRestantes(Integer vagasRestantes) {
//		this.vagasRestantes = vagasRestantes;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
