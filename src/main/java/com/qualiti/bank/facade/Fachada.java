package com.qualiti.bank.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.TipoConta;
import com.qualiti.bank.services.ClienteBO;
import com.qualiti.bank.services.ContaBO;

@Controller
public class Fachada implements IFachada {
	
	@Autowired
	private ContaBO negocioContas;
	@Autowired
	private ClienteBO negocioClientes;
	

	@Override
	public void inserirConta(Conta conta) throws BancoException {
		negocioContas.inserir(conta);
	}

	@Override
	public void atualizarConta(Conta conta) throws BancoException {
		negocioContas.atualizar(conta);
	}

	@Override
	public void removerConta(String numero) throws BancoException {
		negocioContas.remover(numero);
	}

	@Override
	public Conta procurarConta(String numero) throws BancoException {
		return negocioContas.procurar(numero);
	}

	@Override
	public String gerarRelatorioContas() {
		return negocioContas.gerarRelatorioContas();
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		return negocioContas.recuperarSaldoTotalContas(tipo);
	}

	@Override
	public void inserirCliente(Cliente cliente) throws BancoException {
		negocioClientes.inserir(cliente);
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws BancoException {
		negocioClientes.atualizar(cliente);
	}

	@Override
	public void removerCliente(String cpf) throws BancoException {
		negocioClientes.remover(cpf);
	}

	@Override
	public Cliente procurar(String cpf) throws BancoException {
		return negocioClientes.procurar(cpf);
	}

	@Override
	public void creditar(String numero, double valor) throws BancoException {
		negocioContas.creditar(numero, valor);
	}

	@Override
	public void debitar(String numero, double valor) throws BancoException {
		negocioContas.debitar(numero, valor);
	}

	@Override
	public void transferir(String numeroFonte, String numeroDestino, 
			double valor) throws BancoException {
		negocioContas.transferir(numeroFonte, numeroDestino, valor);
	}

	@Override
	public String nomesClienteOrdemAlfabetica() throws BancoException {
		return negocioClientes.nomesClienteOrdemAlfabetica();
	}

}
