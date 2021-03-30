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

import com.Creg.Ecol.Model.Pedido;
import com.Creg.Ecol.Repository.PedidoRepository;
import com.Creg.Ecol.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Pedido>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@GetMapping("/numeroPedido/{numeroPedido}")
	public ResponseEntity<List<Pedido>> GetByDescricao(@PathVariable int numeroPedido) {
		return ResponseEntity.ok(repository. findAllByNumeroPedido(numeroPedido));
	}
	
	@PostMapping
	public ResponseEntity<Pedido> post(@RequestBody Pedido pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.numeroPedido(pedido));
	}
	
	@PutMapping 
	public ResponseEntity<Pedido> put(@RequestBody Pedido pedido){
		return ResponseEntity.ok(repository.save(pedido));
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
