package com.qualiti.bank.services;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;

public interface ClienteBO {
	
	void inserir(Cliente cliente) throws BancoException;
	void atualizar(Cliente cliente) throws BancoException;
	void remover(String cpf) throws BancoException;
	Cliente procurar(String cpf) throws BancoException;

}
