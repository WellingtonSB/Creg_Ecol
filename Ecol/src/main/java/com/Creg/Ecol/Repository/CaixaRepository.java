package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {

	public List<Caixa> findAllByEstadoPedidoContainingIgnoreCase(String estadoPedido);

	@Query(value = "SELECT * FROM tb_produto where ativo = :pagamentoConfirmado", nativeQuery = true)
	public List<Caixa> findAllByPagamentoConfirmado(@Param("pagamentoConfirmado") boolean pagamentoConfirmado);

}
