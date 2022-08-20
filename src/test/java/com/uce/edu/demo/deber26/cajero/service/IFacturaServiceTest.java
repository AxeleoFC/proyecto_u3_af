package com.uce.edu.demo.deber26.cajero.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.deber26.cajero.repository.modelo.Factura;

@SpringBootTest
@Transactional
@Rollback(true)
class IFacturaServiceTest {

	@Autowired
	private IFacturaService iFacturaService;

	@Test
	void testInsertar() {
		Factura f = new Factura();
		f.setNumero("26458964-998-998");
		f.setFecha(LocalDateTime.now());

		this.iFacturaService.insertar(f);

		assertEquals(this.iFacturaService.buscar(f.getId()), f);
	}

	@Test
	void testActualizar() {
		Factura f = new Factura();
		f.setNumero("26458964-998-998");
		f.setFecha(LocalDateTime.now());

		this.iFacturaService.insertar(f);

		f.setNumero("001-001-121212333");

		this.iFacturaService.actualizar(f);

		assertEquals(this.iFacturaService.buscar(f.getId()).getNumero(), f.getNumero());
	}

	@Test
	void testActualizarFechaFacturas() {
		assertThat(this.iFacturaService.actualizarFecha(LocalDateTime.now()) > 0);
	}

	@Test
	void testBuscarFacturaInnerJoin() {
		List<Factura> facturas = this.iFacturaService.buscarFacturaInnerJoin();
		assertThat(facturas).isNotEmpty();
	}

}
