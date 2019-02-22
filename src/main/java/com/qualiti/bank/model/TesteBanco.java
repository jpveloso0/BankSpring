package com.qualiti.bank.model;

import com.qualiti.bank.exceptions.BancoException;

public class TesteBanco {

	public static void main(String[] args) {
		//Nunca lançar uma excessão no main
		Conta c1 = new Conta("1111-2");
		Cliente cli2 = new Cliente("Ana Maria", "088");
		
		c1.setSaldo(2000);
		c1.setCliente(cli2);
		
		System.out.println(c1);
		
		Conta c3 = new Conta("8888-9");
		
		if(c1.getNumero().equals(c3.getNumero())) {
			
		}
		if(c1.equals(c3)) {
			System.out.println("c1 e c3 sao iguais");
		}else {
			System.out.println("c1 e c3 sao diferentes");
		}
		
		Cliente cli = new Cliente();
		
		
		
		if(cli.equals(cli2)) {
			
		}
		
		Poupanca p = new Poupanca();
		p.setSaldo(1000);
		p.setNumero("47653-x");
		
		ContaBonus cb1 = new ContaBonus();
		cb1.creditar(1000);
		
		System.out.println("SALDO CB: "+cb1.getSaldo());
		System.out.println("BONUS CB: "+cb1.getBonus());
		
		p.creditar(500);
		try {
			p.debitar(200);
			System.out.println("Debito realizado com sucesso");
		} catch (BancoException e) {
			System.out.println(e.getMessage());
			
		}finally {
			System.out.println("Volte sempre!");
			
		}
		
		p.renderJuros(0.1);
		
		c1.setNumero("1234-x");
		c1.setSaldo(500);
		c1.creditar(1000);
		
		Conta c2 = new Conta();
		c2.setNumero("3456-1");
		c2.setSaldo(2000);
		
		try {
			c2.debitar(500);
			
		} catch (BancoException e) {
			e.printStackTrace();
		}
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
		c1.setSaldo(1000);
		c2.setSaldo(1000);
		
		try {
			c1.transferir(c2, 500);
			
		} catch (BancoException e) {
			e.printStackTrace();
		}
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
		try {
			c1.transferir(c2, 1000);
			
		} catch (BancoException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
	}

}
