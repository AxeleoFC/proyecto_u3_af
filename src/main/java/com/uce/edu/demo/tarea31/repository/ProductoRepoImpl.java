package com.uce.edu.demo.tarea31.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscarProducto(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.nombre = :datoNombre",
				Producto.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

}
