package com.uce.edu.demo.deber35;

import java.util.concurrent.TimeUnit;

public class Navegador extends Thread{
	
	private Ventana ventana;
	
	public Navegador(Ventana ventana) {
		// TODO Auto-generated constructor stub
		this.ventana=ventana;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(this.ventana);
	}

	public void procesar(Ventana ventana) {
		long teimpoInicial=System.currentTimeMillis();
		System.out.println("Nombre del hilo procesar:"+Thread.currentThread().getName());
		System.out.println("Procesando ventana: "+ventana.getNombre());
		for(String pagina : ventana.getPaginaPestanias()) {
			atenderCliente(pagina);
		}
		System.out.println("A terminado de procesar la ventana: "+this.ventana.getNombre());

		long teimpoFinal=System.currentTimeMillis();
		System.out.println("Total de tiempo cargar ventana: "+this.ventana.getNombre()+": "+(teimpoFinal-teimpoInicial)/1000+" segundos.");
	}
	
	private void atenderCliente(String pagina) {
		System.out.println("Cargando pagina: "+pagina);
		//Demorar en segundos
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
