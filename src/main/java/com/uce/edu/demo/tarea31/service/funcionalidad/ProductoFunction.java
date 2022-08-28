package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;

public class ProductoFunction implements IProductoFunction<Producto, String>{

	@Autowired
	private IProductoService productoService;
	
	@Override
	public Producto aplicar(String arg1) {
		// TODO Auto-generated method stub
		return this.productoService.buscarNombre(arg1);
	}

}
