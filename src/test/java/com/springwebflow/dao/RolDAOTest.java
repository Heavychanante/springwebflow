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

import com.springwebflow.model.Rol;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class RolDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private RolDAO rolDAO;

	@Test
	public void save() {
		Rol rol = new Rol();
		rol.setNombre("test");
		rolDAO.save(rol);
		assertNotNull(rol.getId());
	}

	@Test
	public void findById() {
		Rol rol = new Rol();
		rol.setNombre("test");
		rolDAO.save(rol);
		Rol encontrado = rolDAO.findById(rol.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Rol rol = new Rol();
		rol.setNombre("test");
		rolDAO.save(rol);
		rol.setNombre("test1");
		rolDAO.update(rol);
		Rol encontrado = rolDAO.findById(rol.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Rol rol = new Rol();
		rol.setNombre("test");
		rolDAO.save(rol);
		rolDAO.delete(rol);
		Rol encontrado = rolDAO.findById(rol.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Rol rol = new Rol();
		rol.setNombre("test");
		rolDAO.save(rol);
		List<Rol> list = rolDAO.list();
		assertTrue(list.size() > 0);
	}
}
