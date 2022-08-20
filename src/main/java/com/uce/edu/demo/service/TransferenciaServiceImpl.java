package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Transferencia t) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.actualizar(t);
	}
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//0. Buscar la cuenta Origen (obtener el saldo)
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarCuenta(numeroCtaOrigen);
		//1. Restar el monto a la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		
		//0. Buscar la cuenta Destino (obtener el saldo)
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarCuenta(numeroCtaDestino);
		//2. Sumar el monto a la cuenta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		
		//3. Insertar transferencia
		
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		
		this.transferenciaRepository.insertar(trans);
		/*
		if(ctaOrigen.getTipo().equals("Ahorros")){
			throw new RuntimeException();
		}
		*/
		if(monto.compareTo(saldoOrigen) > 0) {
			throw new RuntimeException();
		}
		
		
	}//commit

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}
	

	@Override
	public void realizarTransferenciaOtroBanco(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria ctaOrigen=this.bancariaRepository.buscarCuenta(numeroOrigen);
		CuentaBancaria ctaDestino=this.bancariaRepository.buscarCuenta(numeroDestino);
		
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto).subtract(new BigDecimal(0.5)));
		this.bancariaRepository.actualizar(ctaOrigen);
		
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto).subtract(new BigDecimal(0.5)));
		this.bancariaRepository.actualizar(ctaDestino);
		
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(trans);
	}

}
