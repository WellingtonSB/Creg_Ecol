package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {

	public List<Caixa> findAllByNomeContainingIgnoreCase(String estadoPedido);

	public List<Caixa> findAllByDescricaoContainingIgnoreCase(String descricao);

	public List<Caixa> findAllBySkuContainingIgnoreCase(int sku);

	@Query(value = "SELECT * FROM tb_produto where ativo = :pagamentoConfirmado", nativeQuery = true)
	public List<Caixa> findAllByPagamentoConfirmado(@Param("pagamentoConfirmado") boolean pagamentoConfirmado);

}
