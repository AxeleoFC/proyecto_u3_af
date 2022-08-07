package com.uce.edu.demo.deber26.cajero.repository;

import java.util.List;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public void ingresar(Factura f);
	public Factura consultar(Integer id);
	
	//Deber 26
	public List<Factura> buacarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buacarFacturaInnerJoin();
	
	public List<Factura> buacarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura> buacarFacturaOuterJoinLeft();
	public List<Factura> buacarFacturaOuterJoinRight(Integer cantidad);
	
	//Deber 27
	/*
	public List<Factura> buacarHotelJoinWhere(String tipoHabitacion);
	public List<Factura> buacarHotelJoinFetch(String tipoHabitacion);*/
}
