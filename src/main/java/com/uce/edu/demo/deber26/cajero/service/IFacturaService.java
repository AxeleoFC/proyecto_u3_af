package com.uce.edu.demo.deber26.cajero.service;

import java.util.List;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;

public interface IFacturaService {
	
	public void ingresar(Factura f);
	public Factura consultar(Integer id);
	
	//Deber 26
	public List<Factura> buacarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buacarFacturaInnerJoin();
		
	public List<Factura> buacarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura> buacarFacturaOuterJoinLeft();
	public List<Factura> buacarFacturaOuterJoinRight(Integer cantidad);

	//Deber 27

	public List<Factura> buacarFacturaJoinWhere(Integer cantidad);

	public List<Factura> buacarFacturaJoinFetch(Integer cantidad);
}
