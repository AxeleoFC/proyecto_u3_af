package com.uce.edu.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(true)
class ProyectoU3AfApplicationTests {


	@Test
	void contextLoads() {
	}


}
