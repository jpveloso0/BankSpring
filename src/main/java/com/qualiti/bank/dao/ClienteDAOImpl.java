package com.qualiti.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAOImpl implements ClienteDAOCustom {
	
	@PersistenceContext
	private EntityManager em;

}
