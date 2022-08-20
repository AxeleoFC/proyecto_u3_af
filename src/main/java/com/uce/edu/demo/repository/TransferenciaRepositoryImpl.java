package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;
@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia t) {
		// TODO Auto-generated method stub
		this.entityManager.persist(t);
		throw new RuntimeException();
	}

	@Override
	public void actualizar(Transferencia t) {
		// TODO Auto-generated method stub
		this.entityManager.merge(t);
	}

}
