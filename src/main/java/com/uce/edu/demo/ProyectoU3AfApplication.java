package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.service.IFacturaElectricaService;

@SpringBootApplication
public class ProyectoU3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());
	
	@Autowired
	private IFacturaElectricaService factElectService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Detalle d1=new Detalle();
		List<Detalle> de=new ArrayList<>();
		de.add(d1);
		this.factElectService.generarFacturaSRI("1752310126", "1", de);
		
	}

}
