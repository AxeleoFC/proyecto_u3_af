package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long teimpoInicial=System.currentTimeMillis();
		List<Integer> listanumerosAlumnos = new ArrayList<>();
		
		for(int i=0;i<5000;i++) {
			listanumerosAlumnos.add(i);
		}
		List<String> listaProcesada = listanumerosAlumnos.parallelStream().map(numero -> convertirIDAlumno(numero)).collect(Collectors.toList());
		
		listaProcesada.forEach(cadena -> System.out.println(cadena));

		long teimpoFinal=System.currentTimeMillis();
		
		System.out.println("Total de tiempo de ejecucion: "+(teimpoFinal-teimpoInicial)/1000+" segundos.");
	}
	
	private static String convertirIDAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID :"+id.toString();
	}

}
