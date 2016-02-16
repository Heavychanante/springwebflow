package com.springwebflow.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springwebflow.model.Campania;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class CampaniaDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CampaniaDAO campaniaDAO;

	@Test
	public void save() {
		Campania campania = new Campania();
		campania.setTitulo("test");
		campania.setActo(0);
		campaniaDAO.save(campania);
		assertNotNull(campania.getId());
	}

	@Test
	public void findById() {
		Campania campania = new Campania();
		campania.setTitulo("test");
		campania.setActo(0);
		campaniaDAO.save(campania);
		Campania encontrado = campaniaDAO.findById(campania.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Campania campania = new Campania();
		campania.setTitulo("test");
		campania.setActo(0);
		campaniaDAO.save(campania);
		campania.setTitulo("test1");
		campaniaDAO.update(campania);
		Campania encontrado = campaniaDAO.findById(campania.getId());
		assertTrue("test1".equals(encontrado.getTitulo()));
	}

	@Test
	public void delete() {
		Campania campania = new Campania();
		campania.setTitulo("test");
		campania.setActo(0);
		campaniaDAO.save(campania);
		campaniaDAO.delete(campania);
		Campania encontrado = campaniaDAO.findById(campania.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Campania campania = new Campania();
		campania.setTitulo("test");
		campania.setActo(0);
		campaniaDAO.save(campania);
		List<Campania> list = campaniaDAO.list();
		assertTrue(list.size() > 0);
	}
}
