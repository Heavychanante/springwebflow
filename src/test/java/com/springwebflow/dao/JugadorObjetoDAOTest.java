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
import com.springwebflow.model.JugadorObjeto;
import com.springwebflow.model.pk.JugadorObjetoPk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class JugadorObjetoDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JugadorObjetoDAO jugadorObjetoDAO;

	@Autowired
	private JugadorDAO jugadorDAO;

	@Test
	public void save() {
		JugadorObjeto jugadorObjeto = new JugadorObjeto();
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
		JugadorObjetoPk pk = new JugadorObjetoPk();
		pk.setJugadorId(jugador.getId());
		pk.setObjetoId(1);
		jugadorObjeto.setId(pk);
		jugadorObjetoDAO.save(jugadorObjeto);
		assertNotNull(jugadorObjeto.getId());
	}

	@Test
	public void findById() {
		JugadorObjeto jugadorObjeto = new JugadorObjeto();
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
		JugadorObjetoPk pk = new JugadorObjetoPk();
		pk.setJugadorId(jugador.getId());
		pk.setObjetoId(1);
		jugadorObjeto.setId(pk);
		jugadorObjetoDAO.save(jugadorObjeto);
		JugadorObjeto encontrado = jugadorObjetoDAO.findById(jugadorObjeto.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		JugadorObjeto jugadorObjeto = new JugadorObjeto();
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
		JugadorObjetoPk pk = new JugadorObjetoPk();
		pk.setJugadorId(jugador.getId());
		pk.setObjetoId(1);
		jugadorObjeto.setId(pk);
		jugadorObjetoDAO.save(jugadorObjeto);
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		jugadorObjeto.setModificacion(ts);
		jugadorObjetoDAO.update(jugadorObjeto);
		JugadorObjeto encontrado = jugadorObjetoDAO.findById(jugadorObjeto.getId());
		assertTrue(date.getTime() == encontrado.getModificacion().getTime());
	}

	@Test
	public void delete() {
		JugadorObjeto jugadorObjeto = new JugadorObjeto();
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
		JugadorObjetoPk pk = new JugadorObjetoPk();
		pk.setJugadorId(jugador.getId());
		pk.setObjetoId(1);
		jugadorObjeto.setId(pk);
		jugadorObjetoDAO.save(jugadorObjeto);
		jugadorObjetoDAO.delete(jugadorObjeto);
		JugadorObjeto encontrado = jugadorObjetoDAO.findById(jugadorObjeto.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		JugadorObjeto jugadorObjeto = new JugadorObjeto();
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
		JugadorObjetoPk pk = new JugadorObjetoPk();
		pk.setJugadorId(jugador.getId());
		pk.setObjetoId(1);
		jugadorObjeto.setId(pk);
		jugadorObjetoDAO.save(jugadorObjeto);
		List<JugadorObjeto> list = jugadorObjetoDAO.list();
		assertTrue(list.size() > 0);
	}
}
