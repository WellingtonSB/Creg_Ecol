package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Creg.Ecol.Model.PratoPrinciapal;



public interface PratoPrincipalRepository extends JpaRepository<PratoPrinciapal, Long> {
	public List<PratoPrinciapal> findAllByNomeContainingIgnoreCase(String nome);
	public List<PratoPrinciapal> findAllByDescricaoContainingIgnoreCase(String descricao);
	public List<PratoPrinciapal> findAllByValorContainingIgnoreCase(double valor);
	@Query(value = "SELECT * FROM tb_produto where ativo = :ativo", nativeQuery = true)
	public List<PratoPrinciapal> findAllByAtivo(@Param("ativo") boolean ativo);	
}