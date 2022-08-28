package com.uce.edu.demo.tarea33;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public class ProductoConsumer implements IProductoConsumer<String> {

	@Override
	public void accerpt(String arg1) {
		// TODO Auto-generated method stub
		Producto p=new Producto();
		p.setNombre(arg1);
		System.out.println("Consumer Clase: "+p.getNombre());
	}

}
