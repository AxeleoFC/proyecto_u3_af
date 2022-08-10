package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static final Logger LOG = LogManager.getLogger(CuentaBancariaRepositoryImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarCuenta(String numero) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa:"+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria>myQuery=this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =:numero",CuentaBancaria.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
