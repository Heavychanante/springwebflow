package com.springwebflow.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springwebflow.model.Jugador;
import com.springwebflow.model.JugadorHabilidad;
import com.springwebflow.model.pk.JugadorHabilidadPk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class JugadorHabilidadDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JugadorHabilidadDAO jugadorHabilidadDAO;

	@Autowired
	private JugadorDAO jugadorDAO;

	@Test
	public void save() {
		JugadorHabilidad jugadorHabilidad = new JugadorHabilidad();
		Jugador jugador = new Jugador();
		jugador.setAlias("test");
		jugador.setAguante(1);
		jugador.setAturdido(Boolean.FALSE);
		jugador.setEnfermo(Boolean.FALSE);
		jugador.setEnvenenado(Boolean.FALSE);
		jugador.setExperiencia(1);
		jugador.setInmovil(Boolean.FALSE);
		jugador.setOro(10);
		jugador.setProeza(Boolean.FALSE);
		jugador.setVida(10);
		jugadorDAO.save(jugador);
		JugadorHabilidadPk pk = new JugadorHabilidadPk();
		pk.setJugadorId(jugador.getId());
		pk.setHabilidadId(1);
		jugadorHabilidad.setId(pk);
		jugadorHabilidad.setCantidad(1);
		jugadorHabilidadDAO.save(jugadorHabilidad);
		assertNotNull(jugadorHabilidad.getId());
	}

	@Test
	public void findById() {
		JugadorHabilidad jugadorHabilidad = new JugadorHabilidad();
		Jugador jugador = new Jugador();
		jugador.setAlias("test");
		jugador.setAguante(1);
		jugador.setAturdido(Boolean.FALSE);
		jugador.setEnfermo(Boolean.FALSE);
		jugador.setEnvenenado(Boolean.FALSE);
		jugador.setExperiencia(1);
		jugador.setInmovil(Boolean.FALSE);
		jugador.setOro(10);
		jugador.setProeza(Boolean.FALSE);
		jugador.setVida(10);
		jugadorDAO.save(jugador);
		JugadorHabilidadPk pk = new JugadorHabilidadPk();
		pk.setJugadorId(jugador.getId());
		pk.setHabilidadId(1);
		jugadorHabilidad.setId(pk);
		jugadorHabilidad.setCantidad(1);
		jugadorHabilidadDAO.save(jugadorHabilidad);
		JugadorHabilidad encontrado = jugadorHabilidadDAO.findById(jugadorHabilidad.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		JugadorHabilidad jugadorHabilidad = new JugadorHabilidad();
		Jugador jugador = new Jugador();
		jugador.setAlias("test");
		jugador.setAguante(1);
		jugador.setAturdido(Boolean.FALSE);
		jugador.setEnfermo(Boolean.FALSE);
		jugador.setEnvenenado(Boolean.FALSE);
		jugador.setExperiencia(1);
		jugador.setInmovil(Boolean.FALSE);
		jugador.setOro(10);
		jugador.setProeza(Boolean.FALSE);
		jugador.setVida(10);
		jugadorDAO.save(jugador);
		JugadorHabilidadPk pk = new JugadorHabilidadPk();
		pk.setJugadorId(jugador.getId());
		pk.setHabilidadId(1);
		jugadorHabilidad.setId(pk);
		jugadorHabilidad.setCantidad(1);
		jugadorHabilidadDAO.save(jugadorHabilidad);
		jugadorHabilidad.setCantidad(2);
		jugadorHabilidadDAO.update(jugadorHabilidad);
		JugadorHabilidad encontrado = jugadorHabilidadDAO.findById(jugadorHabilidad.getId());
		assertTrue(encontrado.getCantidad() == 2);
	}

	@Test
	public void delete() {
		JugadorHabilidad jugadorHabilidad = new JugadorHabilidad();
		Jugador jugador = new Jugador();
		jugador.setAlias("test");
		jugador.setAguante(1);
		jugador.setAturdido(Boolean.FALSE);
		jugador.setEnfermo(Boolean.FALSE);
		jugador.setEnvenenado(Boolean.FALSE);
		jugador.setExperiencia(1);
		jugador.setInmovil(Boolean.FALSE);
		jugador.setOro(10);
		jugador.setProeza(Boolean.FALSE);
		jugador.setVida(10);
		jugadorDAO.save(jugador);
		JugadorHabilidadPk pk = new JugadorHabilidadPk();
		pk.setJugadorId(jugador.getId());
		pk.setHabilidadId(1);
		jugadorHabilidad.setId(pk);
		jugadorHabilidad.setCantidad(1);
		jugadorHabilidadDAO.save(jugadorHabilidad);
		jugadorHabilidadDAO.delete(jugadorHabilidad);
		JugadorHabilidad encontrado = jugadorHabilidadDAO.findById(jugadorHabilidad.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		JugadorHabilidad jugadorHabilidad = new JugadorHabilidad();
		Jugador jugador = new Jugador();
		jugador.setAlias("test");
		jugador.setAguante(1);
		jugador.setAturdido(Boolean.FALSE);
		jugador.setEnfermo(Boolean.FALSE);
		jugador.setEnvenenado(Boolean.FALSE);
		jugador.setExperiencia(1);
		jugador.setInmovil(Boolean.FALSE);
		jugador.setOro(10);
		jugador.setProeza(Boolean.FALSE);
		jugador.setVida(10);
		jugadorDAO.save(jugador);
		JugadorHabilidadPk pk = new JugadorHabilidadPk();
		pk.setJugadorId(jugador.getId());
		pk.setHabilidadId(1);
		jugadorHabilidad.setId(pk);
		jugadorHabilidad.setCantidad(1);
		jugadorHabilidadDAO.save(jugadorHabilidad);
		List<JugadorHabilidad> list = jugadorHabilidadDAO.list();
		assertTrue(list.size() > 0);
	}
}
