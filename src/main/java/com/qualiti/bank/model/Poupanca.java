package com.qualiti.bank.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue (value = "POUPANCA")
public class Poupanca extends Conta {
	
	public void renderJuros(double taxa) {
		double saldoPoupanca = getSaldo();
		saldoPoupanca = saldoPoupanca + saldoPoupanca*taxa;
		setSaldo(saldoPoupanca);
	}
	

}
