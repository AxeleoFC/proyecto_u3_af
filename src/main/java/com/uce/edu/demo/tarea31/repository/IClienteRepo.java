package com.uce.edu.demo.tarea31.repository;

import com.uce.edu.demo.tarea31.repository.modelo.Cliente;

public interface IClienteRepo {
	
	public Cliente buscarCedula(String cedula);

}
