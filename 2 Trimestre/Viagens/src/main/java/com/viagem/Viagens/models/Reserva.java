package com.viagem.Viagens.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import com.viagem.Viagens.models.Passageiro;

@Entity(name="reserva")
public class Reserva {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "origem é obrigatório")
	private String origem;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "destino é obrigatório")
	private String destino;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "data Reserva é obrigatório")
	private String dataReserva;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "hora Saida é obrigatório")
	private String horaSaida;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "empresa é obrigatório")
	private String empresa;
	
	@Column(nullable = false, length = 50)
	@NotEmpty(message = "valorReserva é obrigatório")
	private String valorReserva;
	
	private String observacao;
	
	
	@ManyToOne
	private Passageiro passageiro;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getDataReserva() {
		return dataReserva;
	}


	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}


	public String getHoraSaida() {
		return horaSaida;
	}


	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getValorReserva() {
		return valorReserva;
	}


	public void setValorReserva(String valorReserva) {
		this.valorReserva = valorReserva;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Passageiro getPassageiro() {
		return passageiro;
	}


	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//atenção referente ao certificar, analisar pelo controller e inserir em um outro campo de aviso
	
	
	
	
}

