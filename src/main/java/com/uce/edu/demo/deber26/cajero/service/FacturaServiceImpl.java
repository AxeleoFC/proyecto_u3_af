package com.uce.edu.demo.deber26.cajero.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.deber26.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepo;
	
	@Override
	public void insertar(Factura factura) {
		this.facturaRepo.insertar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		this.facturaRepo.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		this.facturaRepo.eliminar(id);
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
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buacarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buacarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarFacturaJoinFetch(cantidad);
	}

	@Override
	public void ingresar(Factura f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
