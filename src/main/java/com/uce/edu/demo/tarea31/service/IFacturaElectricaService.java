package com.uce.edu.demo.tarea31.service;

import java.util.List;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;

public interface IFacturaElectricaService {
	//Deber 31
	public void generarFacturaSRI(String nomCliente, String numeroFactura, List<Detalle> detalles);

}
