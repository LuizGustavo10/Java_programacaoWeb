package com.example.comapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Evento implements Serializable{
	
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String nome;
		private String cpf;
		private int numVoo;
		private String tipoVoo;//nacional ou internacional
		private double peso;
		private double altura;
		private double largura;
		private double comprimento;
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
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public int getNumVoo() {
			return numVoo;
		}
		public void setNumVoo(int numVoo) {
			this.numVoo = numVoo;
		}
		public String getTipoVoo() {
			return tipoVoo;
		}
		public void setTipoVoo(String tipoVoo) {
			this.tipoVoo = tipoVoo;
		}
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			this.peso = peso;
		}
		public double getAltura() {
			return altura;
		}
		public void setAltura(double altura) {
			this.altura = altura;
		}
		public double getLargura() {
			return largura;
		}
		public void setLargura(double largura) {
			this.largura = largura;
		}
		public double getComprimento() {
			return comprimento;
		}
		public void setComprimento(double comprimento) {
			this.comprimento = comprimento;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
