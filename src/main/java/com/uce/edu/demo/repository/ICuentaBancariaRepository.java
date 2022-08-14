package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	public void insertar(CuentaBancaria c);
	
	public CuentaBancaria buscarCuenta(String numero);

}
