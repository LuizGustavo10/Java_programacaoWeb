package com.viagem.Viagens.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Passageiro {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 9)
	@NotEmpty(message = "O num passaporte é obrigatório")
	private String numeroPassaporte;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "A nacionalidade é obrigatório")
	private String nacionalidade;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "nome para contato obrigatório")
	private String nomeParaContato;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "telefone é obrigatório")
	private String telefoneParaContato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPassaporte() {
		return numeroPassaporte;
	}

	public void setNumeroPassaporte(String numeroPassaporte) {
		this.numeroPassaporte = numeroPassaporte;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNomeParaContato() {
		return nomeParaContato;
	}

	public void setNomeParaContato(String nomeParaContato) {
		this.nomeParaContato = nomeParaContato;
	}

	public String getTelefoneParaContato() {
		return telefoneParaContato;
	}

	public void setTelefoneParaContato(String telefoneParaContato) {
		this.telefoneParaContato = telefoneParaContato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
