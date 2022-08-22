package com.uce.edu.demo.tarea31.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.tarea31.repository.modelo.Factura;

public interface IFacturaRepo {
	
	public void ingresar(Factura f);
	public Factura consultar(Integer id);
	
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public void actualizar(Factura factura);

	public int actualizarFecha(LocalDateTime fecha);

	public Factura buscar(Integer id);

	public Factura buscarPorNumero(String numero);
	
}
