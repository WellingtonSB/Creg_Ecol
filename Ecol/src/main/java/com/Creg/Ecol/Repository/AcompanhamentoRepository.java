package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Acompanhamento;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
	public List<Acompanhamento> findAllByNomeContainingIgnoreCase(String nome);
	public List<Acompanhamento> findAllByDescricaoContainingIgnoreCase(String descricao);
	@Query(value = "SELECT * FROM tb_produto where ativo = :ativo", nativeQuery = true)
	public List<Acompanhamento> findAllByAtivo(@Param("ativo") boolean ativo);	
		
}
