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

import com.springwebflow.model.Arquetipo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class ArquetipoDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ArquetipoDAO arquetipoDAO;

	@Test
	public void save() {
		Arquetipo arquetipo = new Arquetipo();
		arquetipo.setNombre("test");
		arquetipoDAO.save(arquetipo);
		assertNotNull(arquetipo.getId());
	}

	@Test
	public void findById() {
		Arquetipo arquetipo = new Arquetipo();
		arquetipo.setNombre("test");
		arquetipoDAO.save(arquetipo);
		Arquetipo encontrado = arquetipoDAO.findById(arquetipo.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Arquetipo arquetipo = new Arquetipo();
		arquetipo.setNombre("test");
		arquetipoDAO.save(arquetipo);
		arquetipo.setNombre("test1");
		arquetipoDAO.update(arquetipo);
		Arquetipo encontrado = arquetipoDAO.findById(arquetipo.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Arquetipo arquetipo = new Arquetipo();
		arquetipo.setNombre("test");
		arquetipoDAO.save(arquetipo);
		arquetipoDAO.delete(arquetipo);
		Arquetipo encontrado = arquetipoDAO.findById(arquetipo.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Arquetipo arquetipo = new Arquetipo();
		arquetipo.setNombre("test");
		arquetipoDAO.save(arquetipo);
		List<Arquetipo> list = arquetipoDAO.list();
		assertTrue(list.size() > 0);
	}
}
