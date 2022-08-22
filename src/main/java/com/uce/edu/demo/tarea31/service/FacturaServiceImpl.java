package com.uce.edu.demo.tarea31.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IFacturaRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepo facturaRepo;
	
	@Override
	public void insertar(Factura factura) {
		this.facturaRepo.ingresar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.facturaRepo.actualizar(factura);
	}


	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		return this.facturaRepo.actualizarFecha(fecha);
	}

	@Override
	public Factura buscar(Integer id) {
		return this.facturaRepo.buscar(id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		return this.facturaRepo.buscarPorNumero(numero);
	}



}
