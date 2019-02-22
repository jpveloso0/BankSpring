package com.qualiti.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualiti.bank.dao.ContaDAO;
import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.TipoConta;

@Service
public class ContaBOImpl implements ContaBO {
	
	@Autowired
	private ContaDAO repositorio;
	

	@Override
	public void inserir(Conta conta) throws BancoException {
		if(conta == null) {
			throw new BancoException("Objeto Conta null");
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Optional<Conta> contaBusca = repositorio.findById(conta.getNumero());
		if(!contaBusca.isPresent()) { 
			repositorio.save(conta);
		}else {
			throw new BancoException("Número de conta já cadastrado");
		}
		
	}

	@Override
	public void atualizar(Conta conta) throws BancoException {
		if(conta == null) {
			throw new BancoException("Objeto Conta null");
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Optional<Conta> contaBusca = repositorio.findById(conta.getNumero());
		if(contaBusca.isPresent()) { 
			repositorio.save(conta);
		}else {
			throw new BancoException("Número de conta não cadastrado");
		}
		
	}

	@Override
	public void remover(String numero) throws BancoException {
		
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Optional<Conta> contaBusca = repositorio.findById(numero);
		if(contaBusca.isPresent()) { 
			repositorio.delete(contaBusca.get());
		}else {
			throw new BancoException("Número de conta não cadastrado");
		}
		
	}

	@Override
	public Conta procurar(String numero) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Optional<Conta> contaBusca = repositorio.findById(numero);
		if(contaBusca.isPresent()) { 
			return contaBusca.get();
		}
		
		return null;
	}

	@Override
	public String gerarRelatorioContas() {
		return repositorio.gerarRelatorioContas();
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		return repositorio.recuperarSaldoTotalContas(tipo);
	}

	@Override
	public void creditar(String numero, double valor) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Optional<Conta> contaRetornoOptional = repositorio.findById(numero);
		
		if(contaRetornoOptional.isPresent()) {
			
			Conta contaRetorno = contaRetornoOptional.get();
			contaRetorno.creditar(valor);
			repositorio.save(contaRetorno);
	
		}else {
			throw new BancoException("Numero da conta não existe");
		}
		
		
	}

	@Override
	public void debitar(String numero, double valor) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Optional<Conta> contaRetornoOptional = repositorio.findById(numero);
		
		if(contaRetornoOptional.isPresent()) {
			
			Conta contaRetorno = contaRetornoOptional.get();
			contaRetorno.debitar(valor);
			repositorio.save(contaRetorno);
	
		}else {
			throw new BancoException("Numero da conta não existe");
		}
	}

	@Override
	public void transferir(String numeroFonte,
			String numeroDestino, double valor) throws BancoException {
		if(numeroFonte == null || numeroFonte.isEmpty()) {
			throw new BancoException("Número da conta de origem deve ser informado");
		}
		
		if(numeroFonte.length() != 6) {
			throw new BancoException("Número da conta de origem inválido");
		}
		
		if(numeroDestino == null || numeroDestino.isEmpty()) {
			throw new BancoException("Número da conta de destino deve ser informado");
		}
		
		if(numeroDestino.length() != 6) {
			throw new BancoException("Número da conta de destino inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Optional<Conta> contaOrigemRetorno = repositorio.findById(numeroFonte);
		
		if(contaOrigemRetorno.isPresent()) {
			
			Optional<Conta> contaDestinoRetorno = repositorio.findById(numeroDestino);
			
			if(contaDestinoRetorno.isPresent()) {
				
				Conta contaOrigem = contaDestinoRetorno.get();
				Conta contaDestino = contaDestinoRetorno.get();
				contaOrigem.transferir(contaDestino, valor);
				repositorio.save(contaDestino);
				repositorio.save(contaOrigem);
				
			}else {
				throw new BancoException("Numero da conta destino não existe");
			}
			
		}else {
			throw new BancoException("Numero da conta origem não existe");
		}
		
	}

}
