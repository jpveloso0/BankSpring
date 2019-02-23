package com.qualiti.bank.model;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "CLIENTE")
public class Cliente extends Pessoa implements Comparable<Cliente> {
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy="cliente")
	private Set<Conta> contas;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
	}

	@Override
	/**
	 * retorna 0 quando forem objetos com ordem igual
	 * retorna -1 quando this for menor que o parametro
	 * ratorna 1 quando this for maior que o parametro
	 */
	public int compareTo(Cliente o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	public static void main(String[] args) {
		Cliente[] clientes = new Cliente[2];
		
		Cliente cli1 = new Cliente();
		cli1.setNome("Ze Maria");
		
		Cliente cli2 = new Cliente();
		cli2.setNome("Ana");
		
		clientes[0] = cli1;
		clientes[1] = cli2;
		
		Arrays.sort(clientes);
		
		for(Cliente cli : clientes) {
			System.out.println(cli.getNome());
		}
	}

	@Override
	public String getChave() {
		
		return getCpf();
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}
	
}
