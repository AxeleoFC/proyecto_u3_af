package com.uce.edu.demo.tarea31.service.funcionalidad;
@FunctionalInterface
public interface IProductoFunction<R,T> {
	
	public R aplicar(T arg1);

}
