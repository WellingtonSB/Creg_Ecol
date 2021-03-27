package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.Creg.Ecol.Model.PratoPrincipal;

@Repository
public interface PratoPrincipalRepository extends JpaRepository<PratoPrincipal, Long> {
	public List<PratoPrincipal> findAllByNomeContainingIgnoreCase(String nome);

	public List<PratoPrincipal> findAllByDescricaoContainingIgnoreCase(String descricao);

}