package com.uce.edu.demo.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uce.edu.demo.ProyectoU3AfApplication;

public class MainInterfacesFuncionales {
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accerpt("Prueba consumer");
		//Lambdas
		
		IPersonaConsumer<String> consumerLambda = cadena ->System.out.println(cadena);
		consumerLambda.accerpt("Prueba consumer lambda");
				
		//PREDICATE
		//Clases
		//Lambdas
				
		//FUNCTION
		//Clases
		//Lambdas
				
		//UNARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
				
	}

}
