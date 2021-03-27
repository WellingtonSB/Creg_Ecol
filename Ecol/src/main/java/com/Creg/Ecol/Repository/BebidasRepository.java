package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Bebida;

@Repository
public interface BebidasRepository extends JpaRepository<Bebida, Long> {

	public List<Bebida> findAllByNomeContainingIgnoreCase(String nome);
	public List<Bebida> findAllByDescricaoContainingIgnoreCase(String descricao);

	@Query(value = "SELECT * FROM tb_produto where ativo = :ativo", nativeQuery = true)
	public List<Bebida> findAllByAtivo(@Param("ativo") boolean ativo);
}
