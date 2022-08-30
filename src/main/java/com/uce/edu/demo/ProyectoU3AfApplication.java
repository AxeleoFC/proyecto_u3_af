package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IGestorFacturas;
import com.uce.edu.demo.tarea31.service.IProductoService;
import com.uce.edu.demo.tarea31.service.funcionalidad.IProductoConsumer;
import com.uce.edu.demo.tarea31.service.funcionalidad.IProductoFunction;
import com.uce.edu.demo.tarea31.service.funcionalidad.IProductoPredicate;
import com.uce.edu.demo.tarea31.service.funcionalidad.IProductoSupplier;
import com.uce.edu.demo.tarea31.service.funcionalidad.IProductoUnaryOperator;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoConsumer;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoFunction;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoMetodosHighOrder;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoPredicate;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoSupplier;
import com.uce.edu.demo.tarea31.service.funcionalidad.ProductoUnaryOperator;

@SpringBootApplication
public class ProyectoU3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());
	
	@Autowired
	private IGestorFacturas gestorService;
	@Autowired
	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ProductoMetodosHighOrder metodosHO = new ProductoMetodosHighOrder();

		Producto p1=this.productoService.buscarNombre("Chocolate");
		//SUPPLIER
		//Clases
		IProductoSupplier<String> supplierClase=new ProductoSupplier();
		LOG.info("Supplier Clase: "+supplierClase.getNombre());
		
		//Lambdas
		IProductoSupplier<String> supplierLambda=() -> productoService.buscarNombre("Chocolate").getNombre();
		LOG.info("Supplier Lamda: "+supplierLambda.getNombre());
		
		//MEtodos High Order
		String valorHO1 = metodosHO.metodoSupplier(() -> {
			return productoService.buscarNombre("Chocolate").getNombre();
		});
		LOG.info("High Order Supplier Lamda: "+valorHO1);
		//-------------------------------------------------------------------------------
		//CONSUMER
		//Clases
		IProductoConsumer<String> consumerClase=new ProductoConsumer();
		consumerClase.accerpt("Chocolate");
		//Lambdas
		
		IProductoConsumer<String> consumerLambda = cadena ->{
			Producto p=productoService.buscarNombre(cadena);
			System.out.println(p);
		};
		consumerLambda.accerpt("Chocolate");
		
		//MEtodos High Order
		metodosHO.metodoConsumer(cadena ->{
			Producto p=productoService.buscarNombre(cadena);
			System.out.println(p);
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
		IProductoFunction<Producto,String> functionLambda = cadena -> 
			productoService.buscarNombre(cadena);
		LOG.info("Function Lamda: "+functionLambda.aplicar("Chocolate"));
		
		//MEtodos High Order
		Producto valorFinalHO=metodosHO.metodoFunction(cadena -> 
			productoService.buscarNombre(cadena), "Chocolate");
		LOG.info("High Order Function Lamda: "+valorFinalHO);
		
		//-------------------------------------------------------------------------------
		//UNARY OPERATOR (FUNCTION)
		//Clases
		IProductoUnaryOperator<String> unaryClase=new ProductoUnaryOperator();
		LOG.info("Unary Clase: "+unaryClase.apply("Chocolate"));
		//Lambdas
		IProductoUnaryOperator<String> unaryLambda = cadena ->{
			return productoService.buscarNombre(cadena).getNombre();
		};  
		LOG.info("Unary Lamda: "+unaryLambda.apply("Pepe"));
		//MEtodos High Order
		String valorFinalHO2 = metodosHO.metodoUnaryOperatot(valor -> {
			return productoService.buscarNombre(valor).getNombre();
		}, "Chocolate");
		LOG.info("High Order Unary Lamda: " + valorFinalHO2);
		
	}

}
