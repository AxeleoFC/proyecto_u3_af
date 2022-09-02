package com.uce.edu.demo.deber35;

import java.util.List;

public class Ventana {
	
	private String nombre;
	private List<String> paginaPestanias;
	
	public Ventana(String nombre, List<String> paginaPestanias) {
		super();
		this.nombre = nombre;
		this.paginaPestanias = paginaPestanias;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPaginaPestanias() {
		return paginaPestanias;
	}

	public void setPaginaPestanias(List<String> paginaPestanias) {
		this.paginaPestanias = paginaPestanias;
	}
}
