package com.uce.edu.demo.tarea31.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
@Service
public class GestorFacturasServiceImpl implements IGestorFacturas {
	
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IFacturaElectricaService facturaElecService;
	

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String cedula, String numero, List<Detalle> detalles) {
		// TODO Auto-generated method stub
		this.facturaService.crearFactura(cedula, numero, detalles);
		
		this.facturaElecService.generarFacturaSRI(numero);
	}

}
