package com.qualiti.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.qualiti.bank.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAOCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String nomesClienteOrdemAlfabetica() {
		
		//CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		//CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		//Root<Cliente> c = q.from(Cliente.class);
		//q.select(c).orderBy(cb.asc(c.get("nome")));
		//TypedQuery<Cliente> query = entityManager.createQuery(q);
		
		//String sql = "select * from pessoa order by nome asc";
		//Query query = entityManager.createNativeQuery(sql, Cliente.class);
		
		String hql = "from Cliente order by nome asc";
		TypedQuery<Cliente> query =
				entityManager.createQuery(hql, Cliente.class);
		
		
		List<Cliente> clientes = query.getResultList();
		String nomes = "";
		for(Cliente cliente : clientes){
			nomes = nomes + cliente.getNome()+"\n";
		}
		
		return nomes;
	}

}
