package com.uce.edu.demo.tarea31.service;

import java.util.List;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;

public interface IGestorFacturas {
	
	public void crearFactura(String cedula,  String numero, List<Detalle> detalles );

}
