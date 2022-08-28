package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.service.IProductoService;
public class ProductoSupplier implements IProductoSupplier<String> {

	@Autowired
	private IProductoService productoService;
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.productoService.buscarNombre("Chocolate").getNombre();
	}

}
