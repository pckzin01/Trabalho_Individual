package br.org.serratec.TrabalhoIndividual.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo Titulo precisa ser preenchido")
	@Size(max = 100, message = "O campo Titulo pode ter no máximo {max} e no mínimo {min} caracteres")
	@Column
	private String titulo;
	
	@NotBlank(message = "O campo Quantidade de Paginas precisa ser preenchido")
	@Column
	private int qtdPagina;
	
	@Embedded
	private Publicacao publicacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQtdPagina() {
		return qtdPagina;
	}

	public void setQtdPagina(int qtdPagina) {
		this.qtdPagina = qtdPagina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
