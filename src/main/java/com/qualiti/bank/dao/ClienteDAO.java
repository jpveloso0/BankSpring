package com.qualiti.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualiti.bank.model.Cliente;

public interface ClienteDAO extends 
									JpaRepository<Cliente, String>, ClienteDAOCustom{

}
