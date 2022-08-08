package com.uce.edu.demo.deber26.cajero.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class FacturaReposirotyImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Factura f) {
		// TODO Auto-generated method stub
		this.entityManager.persist(f);
	}

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public List<Factura> buacarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles d WHERE d.cantidad >= :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		//return myQuery.getResultList();
		
		//Uso con LAZY
		List<Factura> facturas = myQuery.getResultList();
		for (Factura f : facturas) {
			f.getDetalles().size();
		}
		return facturas;
		
	}

	@Override
	public List<Factura> buacarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles d", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad >= :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad >= :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buacarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f, Detalle d WHERE f=d.factura AND d.cantidad >= :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buacarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.cantidad >= :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

}
