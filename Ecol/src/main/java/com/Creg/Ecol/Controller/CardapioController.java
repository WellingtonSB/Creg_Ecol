package com.Creg.Ecol.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Creg.Ecol.Model.Cardapio;
import com.Creg.Ecol.Repository.CardapioRepository;

@RestController
@RequestMapping("/cardapio")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardapioController {

	@Autowired
	private CardapioRepository repository;

	@GetMapping
	public ResponseEntity<List<Cardapio>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cardapio>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Cardapio>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@GetMapping("/maiorPreco/{preco}")
	public ResponseEntity<List<Cardapio>> GetAllByPrecoMaior(@PathVariable double preco){
		return ResponseEntity.ok(repository.findAllByPrecoGreaterThanEqual(preco));
	}
	
	@GetMapping("/menorPreco/{preco}")
	public ResponseEntity<List<Cardapio>> GetAllByPrecoLess(@PathVariable double preco){
		return ResponseEntity.ok(repository.findAllByPrecoLessThanEqual(preco));
	}
	
	@GetMapping("/ativo/{ativo}")
	public ResponseEntity<List<Cardapio>> GetAllByAtivo(@PathVariable boolean ativo){
		return ResponseEntity.ok(repository.findAllByAtivo(ativo));
	}
	
	@PostMapping
	public ResponseEntity<Cardapio> post(@RequestBody Cardapio cardapio) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cardapio));
	}
	
	@PutMapping
	public ResponseEntity<Cardapio> put(@RequestBody Cardapio cardapio) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cardapio));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
	
}
