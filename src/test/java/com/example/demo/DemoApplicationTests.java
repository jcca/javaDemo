package com.example.demo;

import com.example.demo.models.Restaurante;
import com.example.demo.models.TipoAmbiente;
import com.example.demo.models.TipoComida;
import com.example.demo.services.RestauranteService;
import com.example.demo.services.TipoAmbienteService;
import com.example.demo.services.TipoAmbienteServiceImpl;
import com.example.demo.services.TipoComidaService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	TipoAmbienteService service;
	@Autowired
	RestauranteService restauranteService;
	@Autowired
	TipoComidaService tipoComidaService;
	@Test
	void contextLoads() {
		var ambiente = new TipoAmbiente();
		ambiente.setNombre("asdfaf");
		ambiente.setDescripcion("dfasdfasdfasdf");
		//service.save(ambiente);
		var c = new TipoComida();
		c.setNombre("asdfasdf");
		c = tipoComidaService.save(c);
		//var resta = new Restaurante();
		var resta = restauranteService.findById(5L).get();
		//Hibernate.initialize(resta.getTipoComidas());

		//resta.getTipoComidas().add(new TipoComida());
		restauranteService.save(resta);
	}

}
