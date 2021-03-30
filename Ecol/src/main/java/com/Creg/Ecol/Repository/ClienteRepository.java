package com.Creg.Ecol.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Creg.Ecol.Model.Cliente;



public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	public List<Cliente> findAllByCpfContainingIgnoreCase(String cpf);

}