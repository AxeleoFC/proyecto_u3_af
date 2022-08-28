package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;

public class ProductoConsumer implements IProductoConsumer<String> {
	
	@Autowired
	private IProductoService productoService;

	@Override
	public void accerpt(String arg1) {
		// TODO Auto-generated method stub
		Producto p=this.productoService.buscarNombre(arg1);
		System.out.println(p);
	}

}
