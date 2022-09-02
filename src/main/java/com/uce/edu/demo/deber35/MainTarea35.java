package com.uce.edu.demo.deber35;

import java.util.Arrays;

public class MainTarea35 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Nombre del hilo:"+Thread.currentThread().getName());
		Ventana ventana1=new Ventana("1", Arrays.asList("Chrome", "Youtube"));
		Ventana ventana2=new Ventana("2", Arrays.asList("Youtube"));
		Ventana ventana3=new Ventana("3", Arrays.asList("Wikipedia"));
		Ventana ventana4=new Ventana("4", Arrays.asList("Google","Steam"));
		Ventana ventana5=new Ventana("5", Arrays.asList("Discord"));
		
		Navegador navegador1=new Navegador(ventana1);
		Navegador navegador2=new Navegador(ventana2);
		Navegador navegador3=new Navegador(ventana3);
		Navegador navegador4=new Navegador(ventana4);
		Navegador navegador5=new Navegador(ventana5);
		
		navegador1.start();
		navegador2.start();
		navegador3.start();
		navegador4.start();
		navegador5.start();
		
	}

}
