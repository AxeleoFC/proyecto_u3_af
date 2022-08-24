package com.uce.edu.demo.tarea31.service;

import java.time.LocalDateTime;

import com.uce.edu.demo.tarea31.repository.modelo.Factura;

public interface IFacturaService {
	
	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public int actualizarFecha(LocalDateTime fecha);

	public Factura buscar(Integer id);
	
	public Factura buscarPorNumero(String numero);
	

}
