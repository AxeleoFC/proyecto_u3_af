package com.uce.edu.demo.deber26.cajero.service;

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
	public void ingresar(Factura f) {
		// TODO Auto-generated method stub
		this.facturaRepo.ingresar(f);
	}

	@Override
	public Factura consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepo.consultar(id);
	}

	@Override
	public List<Factura> buacarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buacarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buacarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepo.buacarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buacarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepo.buacarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buacarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buacarFacturaOuterJoinRight(cantidad);
	}

}
