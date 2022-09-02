package com.uce.edu.demo.deber34;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uce.edu.demo.ProyectoU3AfApplication;
import com.uce.edu.demo.tarea33.MainTarea33;

public class MainDeber34 {
	
	public static boolean prueba(Integer numero) {
		return numero>=8;
	}
	
	public static void imprimir(String cadena) {
		LOG.info("Impresion: "+cadena);
	}
	
	public void ejecutar() {
		
		// JAVA Function
		LOG.info("JAVA Supplier ");
		// .limit da el total de retornos que quramos en el forEach
		
		Stream<String> test = Stream.generate(() -> {
			double num=(Math.random()*10)/100;
			return "Numero random "+num;
		}).limit(10);
		test.forEach(cadena -> imprimir(cadena));

		//-------------------------------------------------------------------------------
		//CONSUMER
		
		// JAVA Function
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 3, 2, 16, 8, 5, 9);
		listaNumeros.stream().sorted((x,y)->x.compareTo(y)).forEach(t -> LOG.info("JAVA Consumer " + t));
		//-------------------------------------------------------------------------------
		//PREDICATE
		
		// JAVA Predicate
		LOG.info("JAVA Predicate ");
		Stream<Integer> nuevaLista = listaNumeros.stream().sorted((x,y)->x.compareTo(y)).filter(numero -> prueba(numero));
		nuevaLista.forEach(t -> LOG.info("JAVA Predicate " + t));
		//-------------------------------------------------------------------------------
		//FUNCTION
		
		// JAVA Function
		LOG.info("JAVA Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		listaCambiada.forEach(valor -> imprimir(valor));
		
	}
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainDeber34 m=new MainDeber34();
		m.ejecutar();
	}

}
