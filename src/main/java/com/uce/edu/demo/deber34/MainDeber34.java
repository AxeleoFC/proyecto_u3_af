package com.uce.edu.demo.deber34;

import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.ProyectoU3AfApplication;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;
import com.uce.edu.demo.tarea33.MainTarea33;
import com.uce.edu.demo.tarea33.ProductoMetodosHighOrder;

public class MainDeber34 {
	
	@Autowired
	private IProductoService productoService;
	
	public void ejecutar() {
		ProductoMetodosHighOrder metodosHO = new ProductoMetodosHighOrder();

		//SUPPLIER
		
		//Metodos High Order
		String valorHO1 = metodosHO.metodoSupplier(() -> {
			return "Chocolate".toString();
		});
		// JAVA
		LOG.info("JAVA Supplier ");
		// .limit da el total de retornos que quramos en el forEach
		Stream<String> test = Stream.generate(() -> "Axel test").limit(7);
		test.forEach(cadena -> LOG.info("JAVA Supplier " + cadena));

		//-------------------------------------------------------------------------------
		//CONSUMER
		
		//Metodos High Order
		metodosHO.metodoConsumer(cadena ->{
			Producto p=new Producto();
			p.setNombre(cadena);
			System.out.println("Consumer High Order: "+p.getNombre());
		}, "Chocolate");
				
		//-------------------------------------------------------------------------------
		//PREDICATE
		
		//Metodos High Order
		boolean resultado =  metodosHO.metodoPredicate(cadena -> {
			try {
				Producto p= productoService.buscarNombre(cadena);
				if(p!=null) {
					return true;
				}else {
					return false;
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}, "Chocolate");
		LOG.info("High Order Predicate Lamda: "+resultado);
		
		//-------------------------------------------------------------------------------
		//FUNCTION
		
		//Metodos High Order
		Producto valorFinalHO=metodosHO.metodoFunction(cadena -> {
			Producto p=new Producto();
			p.setNombre(cadena);
			return p;
		}, "Chocolate");
		LOG.info("High Order Function Lamda: "+valorFinalHO);
		
		
	}
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainTarea33 m=new MainTarea33();
		m.ejecutar();
	}

}
