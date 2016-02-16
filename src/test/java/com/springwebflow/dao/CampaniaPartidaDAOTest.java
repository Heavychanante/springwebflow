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

import com.springwebflow.model.CampaniaPartida;
import com.springwebflow.model.pk.CampaniaPartidaPk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class CampaniaPartidaDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CampaniaPartidaDAO campaniaPartidaDAO;

	@Test
	public void save() {
		CampaniaPartida campaniaPartida = new CampaniaPartida();
		CampaniaPartidaPk pk = new CampaniaPartidaPk();
		pk.setCampaniaId(1);
		pk.setPartidaId(1);
		campaniaPartida.setId(pk);
		campaniaPartidaDAO.save(campaniaPartida);
		assertNotNull(campaniaPartida.getId());
	}

	@Test
	public void findById() {
		CampaniaPartida campaniaPartida = new CampaniaPartida();
		CampaniaPartidaPk pk = new CampaniaPartidaPk();
		pk.setCampaniaId(1);
		pk.setPartidaId(1);
		campaniaPartida.setId(pk);
		campaniaPartidaDAO.save(campaniaPartida);
		CampaniaPartida encontrado = campaniaPartidaDAO.findById(campaniaPartida.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		CampaniaPartida campaniaPartida = new CampaniaPartida();
		CampaniaPartidaPk pk = new CampaniaPartidaPk();
		pk.setCampaniaId(1);
		pk.setPartidaId(1);
		campaniaPartida.setId(pk);
		campaniaPartidaDAO.save(campaniaPartida);
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		campaniaPartida.setModificacion(ts);
		campaniaPartidaDAO.update(campaniaPartida);
		CampaniaPartida encontrado = campaniaPartidaDAO.findById(campaniaPartida.getId());
		assertTrue(campaniaPartida.equals(encontrado));
	}

	@Test
	public void delete() {
		CampaniaPartida campaniaPartida = new CampaniaPartida();
		CampaniaPartidaPk pk = new CampaniaPartidaPk();
		pk.setCampaniaId(1);
		pk.setPartidaId(1);
		campaniaPartida.setId(pk);
		campaniaPartidaDAO.save(campaniaPartida);
		campaniaPartidaDAO.delete(campaniaPartida);
		CampaniaPartida encontrado = campaniaPartidaDAO.findById(campaniaPartida.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		CampaniaPartida campaniaPartida = new CampaniaPartida();
		CampaniaPartidaPk pk = new CampaniaPartidaPk();
		pk.setCampaniaId(1);
		pk.setPartidaId(1);
		campaniaPartida.setId(pk);
		campaniaPartidaDAO.save(campaniaPartida);
		List<CampaniaPartida> list = campaniaPartidaDAO.list();
		assertTrue(list.size() > 0);
	}
}
