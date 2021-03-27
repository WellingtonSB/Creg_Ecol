package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Pedido;
import com.Creg.Ecol.Model.PratoPrinciapal;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public List<PratoPrinciapal> findAllByNumeroPedidoContainingIgnoreCase(long numeroPedido);
}
