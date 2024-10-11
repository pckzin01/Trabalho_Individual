package br.org.serratec.TrabalhoIndividual.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.TrabalhoIndividual.domain.Livro;
import br.org.serratec.TrabalhoIndividual.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroRepository lr;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(lr.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> lp = lr.findById(id);
		if (lp.isPresent()) {
			return ResponseEntity.ok(lp.get());
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir (@Valid @RequestBody Livro livro) {
		livro = lr.save(livro);
		return livro;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar (@PathVariable Long id, @RequestBody Livro livro){
		if (!lr.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livro.setId(id);
		livro = lr.save(livro);
		return ResponseEntity.ok(livro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> delete(@PathVariable Long id) {
		if (!lr.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		lr.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
