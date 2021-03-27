package com.Creg.Ecol.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	public Optional<Funcionario> findAllByNomeContainingIgnoreCase(String nome);
	@Query(value = "SELECT * FROM tb_produto where ativo = :ativo", nativeQuery = true)
	public Optional<Funcionario> findAllByAtivo(@Param("ativo") boolean ativo);	
}
