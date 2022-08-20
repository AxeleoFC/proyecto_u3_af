package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String numeroOrigen, String numeroaDestino, BigDecimal monto);
	
	public void realizarTransferenciaFachada(String numeroOrigen, String numeroaDestino, BigDecimal monto);
	
	public void actualizar(Transferencia t);
	
	//Trabajo grupal
	public void realizarTransferenciaOtroBanco(String numeroOrigen, String numeroDestino, BigDecimal monto);

}
