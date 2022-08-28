package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.modelo.Detalle;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IFacturaElectricaService;
import com.uce.edu.demo.tarea31.service.IGestorFacturas;
import com.uce.edu.demo.tarea31.service.IProductoService;
import com.uce.edu.demo.tarea33.IProductoConsumer;
import com.uce.edu.demo.tarea33.IProductoFunction;
import com.uce.edu.demo.tarea33.IProductoPredicate;
import com.uce.edu.demo.tarea33.IProductoSupplier;
import com.uce.edu.demo.tarea33.IProductoUnaryOperator;
import com.uce.edu.demo.tarea33.ProductoConsumer;
import com.uce.edu.demo.tarea33.ProductoFunction;
import com.uce.edu.demo.tarea33.ProductoMetodosHighOrder;
import com.uce.edu.demo.tarea33.ProductoPredicate;
import com.uce.edu.demo.tarea33.ProductoSupplier;
import com.uce.edu.demo.tarea33.ProductoUnaryOperator;

@SpringBootApplication
public class ProyectoU3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3AfApplication.class.getName());
	
	@Autowired
	private IGestorFacturas gestorService;
	@Autowired
	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
	}

}
