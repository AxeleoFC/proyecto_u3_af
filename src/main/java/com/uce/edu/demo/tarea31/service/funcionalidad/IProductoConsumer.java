package com.uce.edu.demo.tarea31.service.funcionalidad;
@FunctionalInterface
public interface IProductoConsumer<T> {
	
	public void accerpt(T arg1);

}
