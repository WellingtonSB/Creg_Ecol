package com.Creg.Ecol.Model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Categorias")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(max = 30)
	private String nome;
	
	@NotNull
	@Size(max=200)
	private String descricao;
	
	@NotNull
	@Digits(integer = 4,fraction= 2)
	private double valor;
	
	@NotNull
	private boolean ativo;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="categoriaCardapio", joinColumns  = @JoinColumn(name="categoria_id"),inverseJoinColumns=@JoinColumn(name="cardapio_id"))
	@JsonIgnoreProperties({"nome","descricao","valor","valor"})
	private List<Cardapio> cardapio = new ArrayList<>();

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Cardapio> getCardapio() {
		return cardapio;
	}

	public void setCardapio(List<Cardapio> cardapio) {
		this.cardapio = cardapio;
	}
	
	
	
	
}
