package com.qualiti.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.qualiti.bank.model.TipoConta;

@Repository
public class ContaDAOImpl implements 
									ContaDAOCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String gerarRelatorioContas() {
		
		return null;
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		
		return 0;
	}

}
