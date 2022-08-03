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
		
		//Inner Join
		LOG.info("Inner Join con parametros");
		List<Hotel> listaHoteles = this.hotelService.buacarHotelInnerJoin("Matrimonial");
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
		LOG.info("Inner Join sin parametros");
		listaHoteles.removeAll(listaHoteles);
		listaHoteles = this.hotelService.buacarHotelInnerJoin();
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
		//Left Join
		LOG.info("Left Join con parametros");
		listaHoteles = this.hotelService.buacarHotelOuterJoinLeft("Matrimonial");
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
		LOG.info("Left Join sin parametros");
		listaHoteles = this.hotelService.buacarHotelOuterJoinLeft();
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
		//Right join
		LOG.info("Right Join");
		listaHoteles = this.hotelService.buacarHotelOuterJoinRight("Matrimonial");
		listaHoteles.stream().forEach(hotel -> {LOG.info("Hotel: "+hotel.getNombre()+" Direccion: "+hotel.getDireccion());});
		
	}

}
