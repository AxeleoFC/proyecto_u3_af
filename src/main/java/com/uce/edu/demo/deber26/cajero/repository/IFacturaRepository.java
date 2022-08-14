package com.uce.edu.demo.deber26.cajero.repository;

import java.util.List;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public void ingresar(Factura f);
	public Factura consultar(Integer id);
	
	//Deber 26
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buscarFacturaInnerJoin();
	
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura> buscarFacturaOuterJoinLeft();
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	
	//Deber 27
	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);
	
	//Trabajo Grupal
	
	
}
