package com.uce.edu.demo.tarea33;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public class ProductoUnaryOperator implements IProductoUnaryOperator<String>{
	
	
	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		Producto p=new Producto();
		p.setNombre(arg1);
		return p.getNombre();
	}

}
