package com.uce.edu.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.HotelRepositoyrImpl;
import com.uce.edu.demo.repository.IHotelRrepository;
import com.uce.edu.demo.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService {
	
	private static final Logger LOG = LogManager.getLogger(HotelRepositoyrImpl.class.getName());

	@Autowired
	private IHotelRrepository hoterlRepo;
	
	@Override
	public List<Hotel> buacarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buacarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buacarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa service:"+TransactionSynchronizationManager.isActualTransactionActive());
		return this.hoterlRepo.buacarHotelJoinFetch(tipoHabitacion);
	}

	@Override
	public List<Hotel> buacarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buacarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.hoterlRepo.buacarHotelOuterJoinLeft();
	}

}
