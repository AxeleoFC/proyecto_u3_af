package com.uce.edu.demo.tarea31.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IDetallesRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaElectronicaRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;
import com.uce.edu.demo.tarea31.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectricaServiceImpl implements IFacturaElectricaService {

	@Autowired
	private IFacturaElectronicaRepo facturaElecRepo;
	@Autowired
	private IDetallesRepo detallesRepo;
	@Autowired
	private IFacturaRepo facturaRepo;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void generarFacturaSRI(String numero) {
		// TODO Auto-generated method stub
		Factura fact=this.facturaRepo.buscarPorNumero(numero);
		List<Detalle> deta=this.detallesRepo.buscarDetalles(fact.getNumero());
		
		FacturaElectronica factElect=new FacturaElectronica();
		
		factElect.setFacturaOriginal(fact);
		factElect.setFecha(LocalDateTime.now());
		BigDecimal total=new BigDecimal(0);
		
		for(Detalle d: deta) {
			total.add(d.getSubTotal());
		}
		
		factElect.setMonto(total);
		this.facturaElecRepo.ingresar(factElect);
		throw new RuntimeException();
	}

}
