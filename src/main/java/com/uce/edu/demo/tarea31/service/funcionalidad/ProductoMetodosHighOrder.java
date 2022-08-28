package com.uce.edu.demo.tarea31.service.funcionalidad;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;

public class ProductoMetodosHighOrder {
	
	@Autowired
	private IProductoService productoService;
	
	public String metodoSupplier(IProductoSupplier<String> funcion) {
		
		return this.productoService.buscarNombre("Chocolate").getNombre();
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
