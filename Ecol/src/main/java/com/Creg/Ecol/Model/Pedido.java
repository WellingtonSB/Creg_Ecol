package com.Creg.Ecol.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private long numeroPedido;//service
	
	
	@NotNull
	private int quantidade;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getNumeroPedido() {
		return numeroPedido;
	}


	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
}
