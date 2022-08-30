package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uce.edu.demo.ProyectoU3AfApplication;

public class MainInterfacesFuncionales {
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());

	public static boolean prueba(Integer numero) {
		return numero>=3;
	}
	
	public static void imprimir(String cadena) {
		LOG.info("Impresion: "+cadena);
	}
	
	public static void guardar(String cadena) {
		LOG.info("JAVA Function "+cadena);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO=new ConsumoMetodosHighOrder();
		
		//SUPPLIER
		//Clases
		IPersonaSupplier<String> supplierClase=new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplierClase.getNombre());
		
		IPersonaSupplier<String> supplierClaseTE=new PersonaSupplierTerImpl();
		LOG.info("Supplier Clase: "+supplierClaseTE.getNombre());
		//Lambdas
		IPersonaSupplier<String> supplierLambda=() -> "Axel con Lamda";
		LOG.info("Supplier Lamda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE=() -> "Pepe tercera edad Lamda";
		LOG.info("Supplier Lamda: "+supplierLambdaTE.getNombre());
		
		//MEtodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		
		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado="1752310126";
			return valorConsultado;
		});
		LOG.info("High Order Supplier Lamda: "+valorHO);
		LOG.info("High Order Supplier Lamda: "+valorHO1);
		
		// JAVA
		 LOG.info("JAVA Supplier ");
		//.limit da el total de retornos que quramos en el forEach
		Stream<String> test=Stream.generate(() -> "Axel test").limit(7);
		test.forEach(cadena -> LOG.info("JAVA Supplier "+cadena));
		
		//-------------------------------------------------------------------------------
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accerpt("Prueba consumer");
		//Lambdas
		
		IPersonaConsumer<String> consumerLambda = cadena ->System.out.println(cadena);
		consumerLambda.accerpt("Prueba consumer lambda");
		
		//MEtodos High Order
		metodosHO.consumirConsumer(cadena ->System.out.println(cadena), 2);
		
		//JAVA
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(t -> LOG.info("JAVA Consumer "+t));
				
		//-------------------------------------------------------------------------------
		//PREDICATE
		//Clases
		//Lambdas
		IPersonaPredicate<String> preidcateLambda= cadena -> cadena.contains("Z"); 
		LOG.info("Predicate Lamda: "+preidcateLambda.evaluar("Axel"));
		
		//MEtodos High Order
		boolean resultado =  metodosHO.consumirPredicate(cadena -> cadena.contains("A"), "Axel");
		LOG.info("High Order Predicate Lamda: "+resultado);
		
		//JAVA Predicate
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero ->prueba(numero));
		nuevaLista.forEach(t -> LOG.info("JAVA Predicate "+t));
		//-------------------------------------------------------------------------------
		//FUNCTION
		//Clases
		//Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal=valor-2;
			return valorFinal;
		};
		LOG.info("Function Lamda: "+functionLambda.aplicar("5"));
		
		//MEtodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor -> {
			String retorno=valor.toString()+"A";
			return retorno;
		}, 1);
		LOG.info("High Order Function Lamda: "+valorFinalHO);
		
		//JAVA Function
		LOG.info("JAVA Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor=numeroLista+1;
			String cadena ="num: "+valor.toString();
			return cadena;
		});
		listaCambiada.forEach(valor -> imprimir(valor));
		//-------------------------------------------------------------------------------
		//Declarativa: ideas/item
		listaNumeros.forEach(valor->imprimir(valor.toString()));
		
		//Imperativa: paso a paso
		for(Integer valor: listaNumeros) {
			imprimir(valor.toString());
		}
		
		//-------------------------------------------------------------------------------
		//UNARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena ->{
			return cadena.concat("sufijo");
		};  
		LOG.info("Unary Lamda: "+unaryLambda.apply("Pepe"));		
	}

}
