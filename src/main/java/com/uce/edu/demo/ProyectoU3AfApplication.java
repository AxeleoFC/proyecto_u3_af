package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Join WHERE
		LOG.info("Join WHERE");
		List<Hotel> listaHoteles = this.hotelService.buacarHotelJoinWhere("Matrimonial");
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
		LOG.info("Inner Join EAGER/LAZY");
		listaHoteles.removeAll(listaHoteles);
		listaHoteles = this.hotelService.buacarHotelInnerJoin("Familiar");
		for(Hotel hotel: listaHoteles) {
			LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());
			LOG.info("Habitacion: "+hotel.getHabitaciones());
		}
		
		//Join Fetch
		LOG.info("Join Fetch");
		listaHoteles.removeAll(listaHoteles);
		listaHoteles = this.hotelService.buacarHotelJoinFetch("Familiar");
		for(Hotel hotel: listaHoteles) {
			LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());
			LOG.info("Habitacion: "+hotel.getHabitaciones());
		}
		
	}

}
