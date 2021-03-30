package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Creg.Ecol.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public List<Pedido> findAllByDescricaoContainingIgnoreCase(String descricao);
	public List<Pedido> findAllByNumeroPedido(int numeroPedido);
}
