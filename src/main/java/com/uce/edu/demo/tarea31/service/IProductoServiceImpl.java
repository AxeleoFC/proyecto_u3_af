package com.uce.edu.demo.tarea31.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IProductoRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo producRepo;
	
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void actualizar(String nombre, Integer total) {
		// TODO Auto-generated method stub
		Producto productoA=this.producRepo.buscarProducto(nombre);
		productoA.setInvetario(productoA.getInvetario()-total);
		this.producRepo.actualizar(productoA);
		
	}

	@Override
	public Producto buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		System.out.println("Service");
		return this.producRepo.buscarProducto(nombre);
	}
}
