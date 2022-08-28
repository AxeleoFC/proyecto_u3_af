package com.uce.edu.demo.tarea33;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.ProyectoU3AfApplication;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IProductoService;

public class MainTarea33 {
	@Autowired
	private IProductoService productoService;
	
	public void ejecutar() {
		ProductoMetodosHighOrder metodosHO = new ProductoMetodosHighOrder();

		//SUPPLIER
		//Clases
		IProductoSupplier<String> supplierClase=new ProductoSupplier();
		LOG.info("Supplier Clase: "+supplierClase.getNombre());
		
		//Lambdas
		IProductoSupplier<String> supplierLambda=() -> "Chocolate";
		LOG.info("Supplier Lamda: "+supplierLambda.getNombre());
		
		//MEtodos High Order
		String valorHO1 = metodosHO.metodoSupplier(() -> {
			return "Chocolate".toString();
		});
		LOG.info("High Order Supplier Lamda: "+valorHO1);
		//-------------------------------------------------------------------------------
		//CONSUMER
		//Clases
		IProductoConsumer<String> consumerClase=new ProductoConsumer();
		consumerClase.accerpt("Chocolate");
		//Lambdas
		
		IProductoConsumer<String> consumerLambda = cadena ->{
			Producto p=new Producto();
			p.setNombre(cadena);
			System.out.println("Consumer Lamda: "+p.getNombre());
		};
		consumerLambda.accerpt("Chocolate");
		
		//MEtodos High Order
		metodosHO.metodoConsumer(cadena ->{
			Producto p=new Producto();
			p.setNombre(cadena);
			System.out.println("Consumer High Order: "+p.getNombre());
		}, "Chocolate");
				
		//-------------------------------------------------------------------------------
		//PREDICATE
		//Clases
		IProductoPredicate<String> preidcateClase=new ProductoPredicate();
		LOG.info("Predicate Clase: "+preidcateClase.evaluar("Chocolate"));
		//Lambdas
		IProductoPredicate<String> preidcateLambda= cadena -> {
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
		}; 
		LOG.info("Predicate Lamda: "+preidcateLambda.evaluar("Chocolate"));
		
		//MEtodos High Order
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
		//Clases
		IProductoFunction<Producto,String> functionClase=new ProductoFunction();
		LOG.info("Function Clase: "+functionClase.aplicar("Chocolate"));
		//Lambdas
		IProductoFunction<Producto,String> functionLambda = cadena -> {
			Producto p=new Producto();
			p.setNombre(cadena);
			return p;
		};
		LOG.info("Function Lamda: "+functionLambda.aplicar("Chocolate"));
		
		//MEtodos High Order
		Producto valorFinalHO=metodosHO.metodoFunction(cadena -> {
			Producto p=new Producto();
			p.setNombre(cadena);
			return p;
		}, "Chocolate");
		LOG.info("High Order Function Lamda: "+valorFinalHO);
		
		//-------------------------------------------------------------------------------
		//UNARY OPERATOR (FUNCTION)
		//Clases
		IProductoUnaryOperator<String> unaryClase=new ProductoUnaryOperator();
		LOG.info("Unary Clase: "+unaryClase.apply("Chocolate"));
		//Lambdas
		IProductoUnaryOperator<String> unaryLambda = cadena ->{
			Producto p=new Producto();
			p.setNombre(cadena);
			return p.getNombre();
		};  
		LOG.info("Unary Lamda: "+unaryLambda.apply("Chocolate"));
		//MEtodos High Order
		String valorFinalHO2 = metodosHO.metodoUnaryOperatot(valor -> {
			Producto p=new Producto();
			p.setNombre(valor);
			return p.getNombre();
		}, "Chocolate");
		LOG.info("High Order Unary Lamda: " + valorFinalHO2);
	}
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainTarea33 m=new MainTarea33();
		m.ejecutar();
	}

}
