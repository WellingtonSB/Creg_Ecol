package com.Creg.Ecol.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
	public List<Cardapio> findAllByNomeContainingIgnoreCase(String nome);

	public List<Cardapio> findAllByDescricaoContainingIgnoreCase(String descricao);

	@Query(value = "SELECT * FROM Cardapio where preco = preco", nativeQuery = true)
	public List<Cardapio> findAllByPrecoLessThanEqual(@Param("preco")double preco);

	@Query(value = "SELECT * FROM Cardapio where preco = preco", nativeQuery = true)
	public List<Cardapio> findAllByPrecoGreaterThanEqual(@Param("preco")double preco);

	@Query(value = "SELECT * FROM Cardapio where ativo = :ativo", nativeQuery = true)
	public List<Cardapio> findAllByAtivo(@Param("ativo") boolean ativo);

}
