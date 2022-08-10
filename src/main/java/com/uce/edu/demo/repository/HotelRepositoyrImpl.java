package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;
@Repository
@Transactional
public class HotelRepositoyrImpl implements IHotelRrepository {
	
	private static final Logger LOG = LogManager.getLogger(HotelRepositoyrImpl.class.getName());

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//h.habitaciones es la referencia a la entidad Habitacion
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		//Uso con EAGER
		//return myQuery.getResultList();
		
		//Uso con LAZY
		List<Hotel> hoteles =myQuery.getResultList();
		for(Hotel h: hoteles) {
			h.getHabitaciones().size();
		}
		return hoteles;
	}

	@Override
	public List<Hotel> buacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buacarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buacarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//SELECT * FROM hotel ho, habitacion ha where ho.hote_id=ha.habi_id_hotel;
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel AND ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//JOIN FETCH
		LOG.info("Transaccion activa:"+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo= :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
				
		return myQuery.getResultList();
	}

}
