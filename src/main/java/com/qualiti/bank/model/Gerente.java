package com.qualiti.bank.model;

public class Gerente extends Pessoa {
	
	private String matricula;
	private double salario;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String getChave() {
		return getCpf();
	}
}
