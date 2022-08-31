package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread{

	private CajeroParalelo cajero;
	
	public PCCajeroParalelo(CajeroParalelo cajero) {
		// TODO Auto-generated constructor stub
		this.cajero=cajero;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {
		long teimpoInicial=System.currentTimeMillis();
		System.out.println("Nombre del hilo procesar:"+Thread.currentThread().getName());
		System.out.println("Procesando cajero: "+cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
			atenderCliente(cliente);
		}
		System.out.println("A terminado de procesar el cajero: "+this.cajero.getNombre());

		long teimpoFinal=System.currentTimeMillis();
		System.out.println("Total de tiempo del cajero "+this.cajero.getNombre()+": "+(teimpoFinal-teimpoInicial)/1000+" segundos.");
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
