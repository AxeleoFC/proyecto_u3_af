package com.uce.edu.demo.tarea31.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
@Repository
@Transactional
public class DetallesRepoImpl implements IDetallesRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Detalle d) {
		// TODO Auto-generated method stub
		this.entityManager.persist(d);
	}
	
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public List<Detalle> buscarDetalles(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Detalle> myQuery = this.entityManager.createQuery("SELECT d FROM Detalle d WHERE d.factura.numero = :datoNumero",
				Detalle.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalle);
	}

}
