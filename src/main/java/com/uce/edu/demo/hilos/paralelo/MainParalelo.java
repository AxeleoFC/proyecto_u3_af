package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long teimpoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre del hilo:"+Thread.currentThread().getName());
		CajeroParalelo cajero1=new CajeroParalelo("Cajero 1", Arrays.asList("Juan"));
		CajeroParalelo cajero2=new CajeroParalelo("Cajero 2", Arrays.asList("Juan cosmico"));
		CajeroParalelo cajero3=new CajeroParalelo("Cajero 3", Arrays.asList("Juan 2"));
		
		CajeroParalelo cajero4=new CajeroParalelo("Cajero 1", Arrays.asList("Juan cosmico1"));
		CajeroParalelo cajero5=new CajeroParalelo("Cajero 2", Arrays.asList("Juan 1"));
		CajeroParalelo cajero6=new CajeroParalelo("Cajero 3", Arrays.asList("Juan cosmico2"));
		
		PCCajeroParalelo gestorAtencion1=new PCCajeroParalelo(cajero1);
		PCCajeroParalelo gestorAtencion2=new PCCajeroParalelo(cajero2);
		PCCajeroParalelo gestorAtencion3=new PCCajeroParalelo(cajero3);
		
		PCCajeroParalelo gestorAtencion4=new PCCajeroParalelo(cajero4);
		PCCajeroParalelo gestorAtencion5=new PCCajeroParalelo(cajero5);
		PCCajeroParalelo gestorAtencion6=new PCCajeroParalelo(cajero6);
		
		gestorAtencion1.start();
		gestorAtencion2.start();
		gestorAtencion3.start();
		gestorAtencion4.start();
		gestorAtencion5.start();
		gestorAtencion6.start();
		
		long teimpoFinal=System.currentTimeMillis();
		
		System.out.println("Total de tiempo de ejecucion: "+(teimpoFinal-teimpoInicial)/1000+" segundos.");

	}

}
