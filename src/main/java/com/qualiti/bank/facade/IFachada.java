package com.qualiti.bank.facade;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.TipoConta;

public interface IFachada {
	
	void inserirConta(Conta conta) throws BancoException;
	void atualizarConta(Conta conta) throws BancoException;
	void removerConta(String numero) throws BancoException;
	Conta procurarConta(String numero) throws BancoException;
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	void creditar(String numero, double valor) throws BancoException;
	void debitar(String numero, double valor) throws BancoException;
	void transferir(String numeroFonte, String numeroDestino, double valor) throws BancoException;
	
	void inserirCliente(Cliente cliente) throws BancoException;
	void atualizarCliente(Cliente cliente) throws BancoException;
	void removerCliente(String cpf) throws BancoException;
	Cliente procurar(String cpf) throws BancoException;
	
	

}
