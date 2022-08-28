package com.uce.edu.demo.tarea31.service.funcionalidad;
@FunctionalInterface
public interface IProductoPredicate<T> {
	
	public boolean evaluar(T arg1); 

}
