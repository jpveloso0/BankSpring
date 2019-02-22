package com.qualiti.bank.model;


public class Poupanca extends Conta {
	
	public void renderJuros(double taxa) {
		double saldoPoupanca = getSaldo();
		saldoPoupanca = saldoPoupanca + saldoPoupanca*taxa;
		setSaldo(saldoPoupanca);
	}
	

}
