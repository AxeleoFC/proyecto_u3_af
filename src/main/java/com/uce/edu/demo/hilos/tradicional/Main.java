package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long teimpoInicial=System.currentTimeMillis();
		
		Cajero cajero1=new Cajero("Cajero 1", Arrays.asList("Juan","Pepe","Pablo","Juan cosmico"));
		Cajero cajero2=new Cajero("Cajero 2", Arrays.asList("Juan 2","Pancho","Pablo2","Juan cosmico1"));
		Cajero cajero3=new Cajero("Cajero 3", Arrays.asList("Juan 2","Miguel","Pablo2.0","Juan cosmico2"));
		
		PCCajero gestorAtencion=new PCCajero();
		
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		long teimpoFinal=System.currentTimeMillis();
		
		System.out.println("Total de tiempo de ejecucion: "+(teimpoFinal-teimpoInicial)/1000+" segundos.");
	}

}
