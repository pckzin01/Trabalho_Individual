package br.org.serratec.TrabalhoIndividual.domain;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Embeddable
public class Publicacao {

	@Size(max = 90)
	@NotBlank(message = "O campo Autor não pode estar vazio")
	private String autor;
	
	@NotNull(message = "O campo Data Publicação não pode ser nulo")
	private LocalDate dataPublicacao;
	
	@NotBlank(message = "O campo Editora não pode estar vazio")
	private String editora;

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
