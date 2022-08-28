package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.tarea31.service.IProductoService;

public class ProductoUnaryOperator implements IProductoUnaryOperator<String>{
	
	@Autowired
	private IProductoService productoService;
	
	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		return this.productoService.buscarNombre(arg1).getNombre();
	}

}
