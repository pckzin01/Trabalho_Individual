package br.org.serratec.TrabalhoIndividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.TrabalhoIndividual.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
