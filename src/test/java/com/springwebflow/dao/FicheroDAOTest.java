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

import com.springwebflow.model.Fichero;
import com.sun.org.apache.bcel.internal.util.ByteSequence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class FicheroDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private FicheroDAO ficheroDAO;

	@Test
	public void save() {
		Fichero fichero = new Fichero();
		byte[] bytes = new byte[10];
		fichero.setNombre("test");
		fichero.setBytes(bytes);
		ficheroDAO.save(fichero);
		assertNotNull(fichero.getId());
	}

	@Test
	public void findById() {
		Fichero fichero = new Fichero();
		byte[] bytes = new byte[10];
		fichero.setNombre("test");
		fichero.setBytes(bytes);
		ficheroDAO.save(fichero);
		Fichero encontrado = ficheroDAO.findById(fichero.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Fichero fichero = new Fichero();
		byte[] bytes = new byte[10];
		fichero.setNombre("test");
		fichero.setBytes(bytes);
		ficheroDAO.save(fichero);
		fichero.setNombre("test1");
		ficheroDAO.update(fichero);
		Fichero encontrado = ficheroDAO.findById(fichero.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Fichero fichero = new Fichero();
		byte[] bytes = new byte[10];
		fichero.setNombre("test");
		fichero.setBytes(bytes);
		ficheroDAO.save(fichero);
		ficheroDAO.delete(fichero);
		Fichero encontrado = ficheroDAO.findById(fichero.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Fichero fichero = new Fichero();
		byte[] bytes = new byte[10];
		fichero.setNombre("test");
		fichero.setBytes(bytes);
		ficheroDAO.save(fichero);
		List<Fichero> list = ficheroDAO.list();
		assertTrue(list.size() > 0);
	}
}
