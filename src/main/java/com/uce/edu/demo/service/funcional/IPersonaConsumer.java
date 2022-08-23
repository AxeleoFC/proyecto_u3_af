package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IPersonaConsumer<T> {

	public void accerpt(T arg1);
	
}
