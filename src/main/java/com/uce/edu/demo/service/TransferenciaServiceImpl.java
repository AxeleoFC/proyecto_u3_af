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
	private ICuentaBancariaRepository cuentaBancariaRepo;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	//Se usa REQUIRED por que crea una transaccion
	//Es una transaccion, porque si no se lo realiza los metodos actualizar e insertar dan error por ser mandatory
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		CuentaBancaria ctaOrigen=this.cuentaBancariaRepo.buscarCuenta(numeroOrigen);
		CuentaBancaria ctaDestino=this.cuentaBancariaRepo.buscarCuenta(numeroDestino);
		
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.cuentaBancariaRepo.actualizar(ctaOrigen);
		
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaBancariaRepo.actualizar(ctaDestino);
		
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepo.insertar(trans);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferenciaFachada(String numeroOrigen, String numeroaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		CuentaBancaria ctaOrigen=this.cuentaBancariaRepo.buscarCuenta(numeroOrigen);
		CuentaBancaria ctaDestino=this.cuentaBancariaRepo.buscarCuenta(numeroaDestino);
		
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.cuentaBancariaRepo.actualizar(ctaOrigen);
		
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaBancariaRepo.actualizar(ctaDestino);
		
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepo.insertar(trans);
	}

}
