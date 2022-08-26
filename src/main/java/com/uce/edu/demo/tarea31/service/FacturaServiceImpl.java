package com.uce.edu.demo.tarea31.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IClienteRepo;
import com.uce.edu.demo.tarea31.repository.IDetallesRepo;
import com.uce.edu.demo.tarea31.repository.IFacturaRepo;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepo facturaRepo;
	@Autowired
	private IDetallesRepo detallesRepo;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IClienteRepo clienteRepo;
	
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

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFactura(String cedula, String numero, List<Detalle> detalles) {
		// TODO Auto-generated method stub
		Cliente cliente=this.clienteRepo.buscarCedula(cedula);
		Factura factura=new Factura();
		factura.setNumero(numero);
		factura.setCliente(cliente);
		
		for(Detalle d: detalles) {
			this.productoService.actualizar(d.getProducto().getNombre(), d.getCantidad());
		}
		for(Detalle d: detalles) {
			d.setFactura(factura);
			this.detallesRepo.ingresar(d);
		}
		factura.setFecha(LocalDateTime.now());
		this.facturaRepo.ingresar(factura);
	}



}
