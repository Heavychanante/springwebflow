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

import com.springwebflow.model.Dado;
import com.springwebflow.model.DadoHabilidad;
import com.springwebflow.model.pk.DadoHabilidadPk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class DadoHabilidadDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DadoHabilidadDAO dadoHabilidadDAO;

	@Autowired
	private DadoDAO dadoDAO;

	@Test
	public void save() {
		DadoHabilidad dadoHabilidad = new DadoHabilidad();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoHabilidadPk pk = new DadoHabilidadPk();
		pk.setDadoId(dado.getId());
		pk.setHabilidadId(1);
		dadoHabilidad.setId(pk);
		dadoHabilidadDAO.save(dadoHabilidad);
		assertNotNull(dadoHabilidad.getId());
	}

	@Test
	public void findById() {
		DadoHabilidad dadoHabilidad = new DadoHabilidad();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoHabilidadPk pk = new DadoHabilidadPk();
		pk.setDadoId(dado.getId());
		pk.setHabilidadId(1);
		dadoHabilidad.setId(pk);
		dadoHabilidadDAO.save(dadoHabilidad);
		DadoHabilidad encontrado = dadoHabilidadDAO.findById(dadoHabilidad.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		DadoHabilidad dadoHabilidad = new DadoHabilidad();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoHabilidadPk pk = new DadoHabilidadPk();
		pk.setDadoId(dado.getId());
		pk.setHabilidadId(1);
		dadoHabilidad.setId(pk);
		dadoHabilidadDAO.save(dadoHabilidad);
		dadoHabilidadDAO.update(dadoHabilidad);
		DadoHabilidad encontrado = dadoHabilidadDAO.findById(dadoHabilidad.getId());
		assertTrue(pk.equals(encontrado.getId()));
	}

	@Test
	public void delete() {
		DadoHabilidad dadoHabilidad = new DadoHabilidad();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoHabilidadPk pk = new DadoHabilidadPk();
		pk.setDadoId(dado.getId());
		pk.setHabilidadId(1);
		dadoHabilidad.setId(pk);
		dadoHabilidadDAO.save(dadoHabilidad);
		dadoHabilidadDAO.delete(dadoHabilidad);
		DadoHabilidad encontrado = dadoHabilidadDAO.findById(dadoHabilidad.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		DadoHabilidad dadoHabilidad = new DadoHabilidad();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoHabilidadPk pk = new DadoHabilidadPk();
		pk.setDadoId(dado.getId());
		pk.setHabilidadId(1);
		dadoHabilidad.setId(pk);
		dadoHabilidadDAO.save(dadoHabilidad);
		List<DadoHabilidad> list = dadoHabilidadDAO.list();
		assertTrue(list.size() > 0);
	}
}
