package com.uce.edu.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@SpringBootTest
@Transactional
@Rollback(true)
class ICuentaBancariaServiceTest {
	
	@Autowired
	private ICuentaBancariaService ctaService;

	@Test
	void testCrearCuenta() {
		assertThat(ctaService.crearCuenta("Ahorros", "85452966", new BigDecimal(50))).isTrue();
	}

	@Test
	void testBuscar() {
		String numero="123123";
		assertEquals(numero, this.ctaService.buscar(numero).getNumero());
	}

	@Test
	void testActualizar() {
		CuentaBancaria cuenta = this.ctaService.buscar("123123");
		cuenta.setTipo("Corriente");
		assertTrue(ctaService.actualizar(cuenta));
	}

}
