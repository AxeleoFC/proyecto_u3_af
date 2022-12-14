package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;
@Repository
@Transactional
public class HotelRepositoyrImpl implements IHotelRrepository {

	@PersistenceContext
	private EntityManager entitumanager;
	
	@Override
	public List<Hotel> buacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//h.habitaciones es la referencia a la entidad Habitacion
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buacarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entitumanager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

}
