package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;

public class ProductoPredicate implements IProductoPredicate<String> {
	
	@Autowired
	private IProductoService productoService;

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		try {
			Producto p= this.productoService.buscarNombre(arg1);
			if(p!=null) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
