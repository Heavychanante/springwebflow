package com.springwebflow.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.security.Permissions;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springwebflow.model.Personaje;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class PersonajeDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PersonajeDAO personajeDAO;

	@Test
	public void save() {
		Personaje personaje = new Personaje();
		personaje.setNombre("test");
		personaje.setCapacidad("test");
		personaje.setVelocidad(10);
		personaje.setVida(10);
		personaje.setAguante(10);
		personaje.setDefensa(10);
		personaje.setFuerza(10);
		personaje.setConocimiento(10);
		personaje.setVoluntad(10);
		personaje.setPercepcion(10);
		personaje.setProeza("test");
		personajeDAO.save(personaje);
		assertNotNull(personaje.getId());
	}

	@Test
	public void findById() {
		Personaje personaje = new Personaje();
		personaje.setNombre("test");
		personaje.setCapacidad("test");
		personaje.setVelocidad(10);
		personaje.setVida(10);
		personaje.setAguante(10);
		personaje.setDefensa(10);
		personaje.setFuerza(10);
		personaje.setConocimiento(10);
		personaje.setVoluntad(10);
		personaje.setPercepcion(10);
		personaje.setProeza("test");
		personajeDAO.save(personaje);
		Personaje encontrado = personajeDAO.findById(personaje.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Personaje personaje = new Personaje();
		personaje.setNombre("test");
		personaje.setCapacidad("test");
		personaje.setVelocidad(10);
		personaje.setVida(10);
		personaje.setAguante(10);
		personaje.setDefensa(10);
		personaje.setFuerza(10);
		personaje.setConocimiento(10);
		personaje.setVoluntad(10);
		personaje.setPercepcion(10);
		personaje.setProeza("test");
		personajeDAO.save(personaje);
		personaje.setNombre("test1");
		personajeDAO.update(personaje);
		Personaje encontrado = personajeDAO.findById(personaje.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Personaje personaje = new Personaje();
		personaje.setNombre("test");
		personaje.setCapacidad("test");
		personaje.setVelocidad(10);
		personaje.setVida(10);
		personaje.setAguante(10);
		personaje.setDefensa(10);
		personaje.setFuerza(10);
		personaje.setConocimiento(10);
		personaje.setVoluntad(10);
		personaje.setPercepcion(10);
		personaje.setProeza("test");
		personajeDAO.save(personaje);
		personajeDAO.delete(personaje);
		Personaje encontrado = personajeDAO.findById(personaje.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Personaje personaje = new Personaje();
		personaje.setNombre("test");
		personaje.setCapacidad("test");
		personaje.setVelocidad(10);
		personaje.setVida(10);
		personaje.setAguante(10);
		personaje.setDefensa(10);
		personaje.setFuerza(10);
		personaje.setConocimiento(10);
		personaje.setVoluntad(10);
		personaje.setPercepcion(10);
		personaje.setProeza("test");
		personajeDAO.save(personaje);
		List<Personaje> list = personajeDAO.list();
		assertTrue(list.size() > 0);
	}
}
