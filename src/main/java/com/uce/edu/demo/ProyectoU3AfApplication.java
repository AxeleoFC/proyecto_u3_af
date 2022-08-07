package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;
import com.uce.edu.demo.deber26.cajero.service.IFacturaService;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());
	
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Inner Join
		LOG.info("Inner Join con parametros");
		List<Factura> listaFacturas = this.facturaService.buacarFacturaInnerJoin(1);
		listaFacturas.stream().forEach(factura -> {
			LOG.info("Factura: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		});

		LOG.info("Inner Join sin parametros");
		listaFacturas.removeAll(listaFacturas);
		listaFacturas = this.facturaService.buacarFacturaInnerJoin();
		listaFacturas.stream().forEach(factura -> {
			LOG.info("Factura: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		});;

		// Left Join
		LOG.info("Left Join con parametros");
		listaFacturas = this.facturaService.buacarFacturaOuterJoinLeft(1);
		listaFacturas.stream().forEach(factura -> {
			LOG.info("Factura: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		});;

		LOG.info("Left Join sin parametros");
		listaFacturas = this.facturaService.buacarFacturaOuterJoinLeft();
		listaFacturas.stream().forEach(factura -> {
			LOG.info("Factura: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		});;

		// Right join
		LOG.info("Right Join");
		listaFacturas = this.facturaService.buacarFacturaOuterJoinRight(1);
		listaFacturas.stream().forEach(factura -> {
			LOG.info("Factura: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		});;

	}

}
