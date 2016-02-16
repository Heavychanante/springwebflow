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

import com.springwebflow.model.Clase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class ClaseDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ClaseDAO claseDAO;

	@Test
	public void save() {
		Clase clase = new Clase();
		clase.setNombre("test");
		claseDAO.save(clase);
		assertNotNull(clase.getId());
	}

	@Test
	public void findById() {
		Clase clase = new Clase();
		clase.setNombre("test");
		claseDAO.save(clase);
		Clase encontrado = claseDAO.findById(clase.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Clase clase = new Clase();
		clase.setNombre("test");
		claseDAO.save(clase);
		clase.setNombre("test1");
		claseDAO.update(clase);
		Clase encontrado = claseDAO.findById(clase.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Clase clase = new Clase();
		clase.setNombre("test");
		claseDAO.save(clase);
		claseDAO.delete(clase);
		Clase encontrado = claseDAO.findById(clase.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Clase clase = new Clase();
		clase.setNombre("test");
		claseDAO.save(clase);
		List<Clase> list = claseDAO.list();
		assertTrue(list.size() > 0);
	}
}
