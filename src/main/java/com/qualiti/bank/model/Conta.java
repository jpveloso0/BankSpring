package com.qualiti.bank.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qualiti.bank.exceptions.BancoException;

@Entity
@Table (name = "conta")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", 
					discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "CORRENTE")
public class Conta extends BancoEntity<String> {
	
	@Id
	private String numero;
	
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Cliente cliente;
	
	
	@Enumerated(EnumType.STRING)
	@Column(insertable = false, updatable = false)
	private TipoConta tipo;
	
	public Conta() {
		saldo = 1000;
	}
	
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Descrição Conta:\n");
		sb.append("Número: ").append(this.numero).append("\n");
		sb.append("Saldo: ").append(this.saldo).append("\n");
		sb.append("Cliente: ").append(this.cliente.getNome()).append("\n");
		
		return sb.toString();
		
	}
	
	public void creditar(double valor) {
		saldo = saldo + valor;
	}
	
	public void debitar(double valor) throws BancoException {
		if(valor <= saldo) {
			saldo = saldo - valor;
		}else {
			throw new BancoException("Saldo insuficiente");
		}
	}
	
	public void transferir(Conta contaDestino, double valor) throws BancoException {
		
		debitar(valor);
		contaDestino.creditar(valor);
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Conta))
			return false;
		Conta other = (Conta) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getChave() {
		
		return numero;
	}
}
