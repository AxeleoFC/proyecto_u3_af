package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> buacarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buacarHotelInnerJoin();
	
	public List<Hotel> buacarHotelOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buacarHotelOuterJoinLeft();
	
	
	public List<Hotel> buacarHotelOuterJoinRight(String tipoHabitacion);
	public List<Hotel> buacarHotelJoinWhere(String tipoHabitacion);
	public List<Hotel> buacarHotelJoinFetch(String tipoHabitacion);

}
