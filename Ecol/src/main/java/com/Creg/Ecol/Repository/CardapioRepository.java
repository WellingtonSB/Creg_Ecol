package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
	public List<Cardapio> findAllByNomeContainingIgonereCase(String nome);

	public List<Cardapio> findAllByDescricaoContainingIgonereCase(String descricao);

	public List<Cardapio> findAllByValor(double valor);

	@Query(value = "SELECT * FROM Cardapio where ativo = :ativo", nativeQuery = true)
	public List<Cardapio> findAllByAtivo(@Param("ativo") boolean ativo);
}
