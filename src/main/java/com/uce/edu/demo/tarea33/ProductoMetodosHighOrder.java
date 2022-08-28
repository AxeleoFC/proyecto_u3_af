package com.uce.edu.demo.tarea33;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public class ProductoMetodosHighOrder {

	
	public String metodoSupplier(IProductoSupplier<String> funcion) {
		
		return "Chocolate";
	}
	
	public void metodoConsumer(IProductoConsumer<String> funcion, String valor) {
		funcion.accerpt(valor);
	}
	
	public boolean metodoPredicate(IProductoPredicate<String> funcion, String valor) {
		
		return funcion.evaluar(valor);
	}
	
	public Producto metodoFunction(IProductoFunction<Producto, String>funcion, String valor) {
		
		return funcion.aplicar(valor);
	}
	
    public String metodoUnaryOperatot(IProductoUnaryOperator<String>funcion, String valor) {
		
		return funcion.apply(valor);
	}

}
