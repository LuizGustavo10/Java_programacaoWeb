package com.dev.comapp.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "posts")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	@NotEmpty(message = "Autor é uma informação obrigatória.")
	private String autor;

	@Column(nullable = false, length = 150)
	@NotEmpty(message = "Título é uma informação obrigatória.")
	private String titulo;

	@Column(nullable = false, length = 2000)
	@NotEmpty(message = "Texto é uma informação obrigatória.")
	private String texto;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;

	@ManyToOne
	private Categoria categoriaPost;

	public Categoria getCategoriaPost() {
		return categoriaPost;
	}

	public void setCategoriaPost(Categoria categoriaPost) {
		this.categoriaPost = categoriaPost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}