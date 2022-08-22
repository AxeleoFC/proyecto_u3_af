package com.uce.edu.demo.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;
@Repository
@Transactional
public class FacturaElectronicaRepoImpl implements IFacturaElectronicaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(FacturaElectronica f) {
		// TODO Auto-generated method stub
		this.entityManager.persist(f);
		
		throw new RuntimeException();
	}

}
