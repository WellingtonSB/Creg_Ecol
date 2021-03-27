package com.Creg.Ecol.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Caixa")
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private int numeroCaixa;

	@NotNull
	private String estadoPedido;

	@NotNull
	private int sku;

	@NotNull
	private boolean bebida;

	@NotNull
	private boolean pagamentoConfirmado;

	@NotNull
	@Digits(integer = 4, fraction = 2)
	private double valor;

	/*@OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("caixa")
	private List<Funcionario> funcionario;*/

	public int getNumeroCaixa() {
		return numeroCaixa;
	}

	public void setNumeroCaixa(int numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public boolean isBebida() {
		return bebida;
	}

	public void setBebida(boolean bebida) {
		this.bebida = bebida;
	}

	public boolean isPagamentoConfirmado() {
		return pagamentoConfirmado;
	}

	public void setPagamentoConfirmado(boolean pagamentoConfirmado) {
		this.pagamentoConfirmado = pagamentoConfirmado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/*public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}*/

}
