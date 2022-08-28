package com.uce.edu.demo.tarea33;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public class ProductoFunction implements IProductoFunction<Producto, String>{
	
	@Override
	public Producto aplicar(String arg1) {
		// TODO Auto-generated method stub
		Producto p=new Producto();
		p.setNombre(arg1);
		return p;
	}

}
