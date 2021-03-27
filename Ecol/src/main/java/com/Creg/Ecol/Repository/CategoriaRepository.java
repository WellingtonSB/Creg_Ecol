package com.Creg.Ecol.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Categorias;


@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Long>{
	public List<Categorias> findAllByNomeContainingIgonereCase(String nome);

	public List<Categorias> findAllByDescricaoContainingIgonereCase(String descricao);

	public List<Categorias> findAllByValor(double valor);

	@Query(value = "SELECT * FROM Categorias where ativo = :ativo", nativeQuery = true)
	public List<Categorias> findAllByAtivo(@Param("ativo") boolean ativo);
	

}
