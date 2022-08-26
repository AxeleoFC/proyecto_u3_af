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
		Producto p1=this.productoService.buscarCedula("Chocolate");
		Producto p2=this.productoService.buscarCedula("Coca cola");
		
		Detalle d1=new Detalle();
		int cant=1;
		d1.setCantidad(cant);
		BigDecimal total=p1.getPrecio().multiply(new BigDecimal(cant));
		d1.setSubTotal(total);
		d1.setProducto(p1);
		
		Detalle d2=new Detalle();
		d2.setCantidad(cant);
		BigDecimal total2=p2.getPrecio().multiply(new BigDecimal(cant));
		d2.setSubTotal(total2);
		d2.setProducto(p2);
		
		List<Detalle> detalles=new ArrayList<>();
		detalles.add(d1);
		detalles.add(d2);
		
		this.gestorService.crearFactura("1752310126", "1", detalles);
		
	}

}
