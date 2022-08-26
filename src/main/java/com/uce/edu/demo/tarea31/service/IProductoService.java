package com.uce.edu.demo.tarea31.service;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public interface IProductoService {
	
	public void actualizar(String nombre, Integer total);
	public Producto buscarCedula(String nombre);

}
