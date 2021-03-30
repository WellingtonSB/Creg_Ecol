package com.Creg.Ecol.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Creg.Ecol.Model.Cliente;
import com.Creg.Ecol.Model.Pedido;
import com.Creg.Ecol.Repository.ClienteRepository;
import com.Creg.Ecol.Repository.PedidoRepository;

@Service
public class PedidoService {
	Random aleatorio = new Random(8000);

	@Autowired
	private PedidoRepository repository;

	public Pedido numeroPedido(Pedido pedido) {
		List<Pedido> pedidos = repository.findAll();

		int last = pedidos.size() - 1;

		if (pedidos.size() != 0) {
			pedido.setNumeroPedido(pedidos.get(last).getNumeroPedido() + aleatorio.nextInt(999));
		} else {
			pedido.setNumeroPedido(734);
			repository.save(pedido);
		}
		return pedido;
	}

	@Autowired
	private ClienteRepository crepository;

	public Cliente clientePedido(long pedido_id, long cliente_id) {

		Optional<Pedido> pedidoExistente = repository.findById(pedido_id);
		Optional<Cliente> clienteExistente = crepository.findById(cliente_id);

		if (pedidoExistente.isPresent() && clienteExistente.isPresent()) {

			clienteExistente.get().getPedido().add(pedidoExistente.get());
			crepository.save(clienteExistente.get());
			return crepository.save(clienteExistente.get());
		}
		return null;
	}

}
