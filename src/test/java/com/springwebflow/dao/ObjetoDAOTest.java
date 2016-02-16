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

import com.springwebflow.model.Objeto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class ObjetoDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ObjetoDAO objetoDAO;

	@Test
	public void save() {
		Objeto objeto = new Objeto();
		objeto.setaDistancia(Boolean.FALSE);
		objeto.setManos(1);
		objeto.setNombre("test");
		objeto.setDescripcion("test");
		objeto.setPrecio(100);
		objeto.setTipo("test");
		objetoDAO.save(objeto);
		assertNotNull(objeto.getId());
	}

	@Test
	public void findById() {
		Objeto objeto = new Objeto();
		objeto.setaDistancia(Boolean.FALSE);
		objeto.setManos(1);
		objeto.setNombre("test");
		objeto.setDescripcion("test");
		objeto.setPrecio(100);
		objeto.setTipo("test");
		objetoDAO.save(objeto);
		Objeto encontrado = objetoDAO.findById(objeto.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Objeto objeto = new Objeto();
		objeto.setaDistancia(Boolean.FALSE);
		objeto.setManos(1);
		objeto.setNombre("test");
		objeto.setDescripcion("test");
		objeto.setPrecio(100);
		objeto.setTipo("test");
		objetoDAO.save(objeto);
		objeto.setNombre("test1");
		objetoDAO.update(objeto);
		Objeto encontrado = objetoDAO.findById(objeto.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Objeto objeto = new Objeto();
		objeto.setaDistancia(Boolean.FALSE);
		objeto.setManos(1);
		objeto.setNombre("test");
		objeto.setDescripcion("test");
		objeto.setPrecio(100);
		objeto.setTipo("test");
		objetoDAO.save(objeto);
		objetoDAO.delete(objeto);
		Objeto encontrado = objetoDAO.findById(objeto.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Objeto objeto = new Objeto();
		objeto.setaDistancia(Boolean.FALSE);
		objeto.setManos(1);
		objeto.setNombre("test");
		objeto.setDescripcion("test");
		objeto.setPrecio(100);
		objeto.setTipo("test");
		objetoDAO.save(objeto);
		List<Objeto> list = objetoDAO.list();
		assertTrue(list.size() > 0);
	}
}
