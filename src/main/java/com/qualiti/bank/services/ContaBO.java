package com.qualiti.bank.services;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.TipoConta;

public interface ContaBO {
	
	void inserir(Conta conta) throws BancoException;
	void atualizar(Conta conta) throws BancoException;
	void remover(String numero) throws BancoException;
	Conta procurar(String numero) throws BancoException;
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	void creditar(String numero, double valor) throws BancoException;
	void debitar(String numero, double valor) throws BancoException;
	void transferir(String numeroFonte, String numeroDestino, double valor) throws BancoException;

}
