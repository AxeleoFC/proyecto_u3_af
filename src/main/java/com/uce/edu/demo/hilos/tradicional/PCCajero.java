package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {
	
	public void procesar(Cajero cajero) {
		System.out.println("Nombre del hilo procesar:"+Thread.currentThread().getName());
		System.out.println("Procesando cajero: "+cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
			atenderCliente(cliente);
		}
		
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo al cliente: "+cliente);
		//Demorar en segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
