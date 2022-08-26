package com.uce.edu.demo.tarea31.repository;

import java.util.List;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;

public interface IDetallesRepo {
	
	public void ingresar(Detalle d);
	
	public List<Detalle> buscarDetalles(String numero);
	
	public void actualizar(Detalle detalle);

}
