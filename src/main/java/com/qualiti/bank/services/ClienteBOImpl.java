package com.qualiti.bank.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualiti.bank.dao.ClienteDAO;
import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;

@Service
public class ClienteBOImpl implements ClienteBO {
	
	@Autowired
	private ClienteDAO repositorio;
	
	

	@Override
	public void inserir(Cliente cliente) throws BancoException {
		if(cliente == null) {
			throw new BancoException("Objeto Cliente null");
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cliente.getCpf().length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Optional<Cliente> clienteBusca = repositorio.findById(cliente.getCpf());
		if(!clienteBusca.isPresent()) {
			repositorio.save(cliente);
		}else {
			throw new BancoException("CPF já cadastrado");
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws BancoException {
		if(cliente == null) {
			throw new BancoException("Objeto Cliente null");
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cliente.getCpf().length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Optional<Cliente> clienteBusca = repositorio.findById(cliente.getCpf());
		if(clienteBusca.isPresent()) {
			repositorio.save(cliente);
		}else {
			throw new BancoException("CPF não cadastrado");
		}
	}

	@Override
	public void remover(String cpf) throws BancoException {
		if(cpf == null || cpf.isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cpf.length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Optional<Cliente> clienteBusca = repositorio.findById(cpf);
		if(clienteBusca.isPresent()){
			repositorio.delete(clienteBusca.get());
		}
		
	}

	@Override
	public Cliente procurar(String cpf) throws BancoException {
		if(cpf == null || cpf.isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cpf.length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Optional<Cliente> clienteBusca = repositorio.findById(cpf);
		if(clienteBusca.isPresent()){
			return clienteBusca.get();
		}
		
		return null;
	}

	@Override
	public String nomesClienteOrdemAlfabetica() throws BancoException {
		return repositorio.nomesClienteOrdemAlfabetica();
	}

}
