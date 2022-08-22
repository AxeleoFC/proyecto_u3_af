package com.uce.edu.demo.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IClienteRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;
import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectricaServiceImpl implements IFacturaElectricaService {

	@Autowired
	private IFacturaRepo facturaRepo;
	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private IFacturaElectronicaRepo facturaElecRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void generarFacturaSRI(String nomCliente, String numeroFactura, List<Detalle> detalles) {
		// TODO Auto-generated method stub
		Cliente clie=this.clienteRepo.buscarCedula(nomCliente);
		Factura fact=this.facturaRepo.buscarPorNumero(numeroFactura);
		
		FacturaElectronica factElect=new FacturaElectronica();
		factElect.setFacturaOriginal(fact);
		factElect.setDetalles(detalles);
		factElect.setFecha(LocalDateTime.now());
		BigDecimal total=new BigDecimal(0);
		for(Detalle d: detalles) {
			total.add(d.getSubTotal());
		}
		factElect.setMonto(total);
		this.facturaElecRepo.ingresar(factElect);
	}

}
