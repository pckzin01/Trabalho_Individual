package br.org.serratec.TrabalhoIndividual.domain;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class Publicacao {

	private String autor;
	
	private LocalDate dataPublicacao;
	
	private String editora;

	public Publicacao(String autor, LocalDate dataPublicacao, String editora) {
		super();
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
	
}
