package com.Creg.Ecol.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Creg.Ecol.Model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>{

}
