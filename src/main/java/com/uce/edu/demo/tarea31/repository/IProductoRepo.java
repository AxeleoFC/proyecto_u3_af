package com.uce.edu.demo.tarea31.repository;

import com.uce.edu.demo.tarea31.repository.modelo.Producto;

public interface IProductoRepo {
	
	public void actualizar(Producto producto);
	public Producto buscarProducto(String nombre);

}
