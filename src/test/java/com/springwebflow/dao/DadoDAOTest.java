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

import com.springwebflow.model.Dado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class DadoDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DadoDAO dadoDAO;

	@Test
	public void save() {
		Dado dado = new Dado();
		dado.setColor("test");
		dado.setTipo("test");
		dadoDAO.save(dado);
		assertNotNull(dado.getId());
	}

	@Test
	public void findById() {
		Dado dado = new Dado();
		dado.setColor("test");
		dado.setTipo("test");
		dadoDAO.save(dado);
		Dado encontrado = dadoDAO.findById(dado.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Dado dado = new Dado();
		dado.setColor("test");
		dado.setTipo("test");
		dadoDAO.save(dado);
		dado.setColor("test1");
		dadoDAO.update(dado);
		Dado encontrado = dadoDAO.findById(dado.getId());
		assertTrue("test1".equals(encontrado.getColor()));
	}

	@Test
	public void delete() {
		Dado dado = new Dado();
		dado.setColor("test");
		dado.setTipo("test");
		dadoDAO.save(dado);
		dadoDAO.delete(dado);
		Dado encontrado = dadoDAO.findById(dado.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Dado dado = new Dado();
		dado.setColor("test");
		dado.setTipo("test");
		dadoDAO.save(dado);
		List<Dado> list = dadoDAO.list();
		assertTrue(list.size() > 0);
	}
}
