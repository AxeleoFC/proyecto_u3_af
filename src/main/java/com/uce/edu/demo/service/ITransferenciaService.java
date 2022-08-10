package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String numeroOrigen, String numeroaDestino, BigDecimal monto);
	
	public void realizarTransferenciaFachada(String numeroOrigen, String numeroaDestino, BigDecimal monto);

}
