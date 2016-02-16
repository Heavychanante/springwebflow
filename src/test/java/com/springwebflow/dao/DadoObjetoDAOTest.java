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
import com.springwebflow.model.DadoObjeto;
import com.springwebflow.model.pk.DadoObjetoPk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class DadoObjetoDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DadoObjetoDAO dadoObjetoDAO;

	@Autowired
	private DadoDAO dadoDAO;

	@Test
	public void save() {
		DadoObjeto dadoObjeto = new DadoObjeto();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoObjetoPk pk = new DadoObjetoPk();
		pk.setDadoId(dado.getId());
		pk.setObjetoId(1);
		dadoObjeto.setId(pk);
		dadoObjeto.setCantidad(1);
		dadoObjetoDAO.save(dadoObjeto);
		assertNotNull(dadoObjeto.getId());
	}

	@Test
	public void findById() {
		DadoObjeto dadoObjeto = new DadoObjeto();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoObjetoPk pk = new DadoObjetoPk();
		pk.setDadoId(dado.getId());
		pk.setObjetoId(1);
		dadoObjeto.setCantidad(1);
		dadoObjeto.setId(pk);
		dadoObjetoDAO.save(dadoObjeto);
		DadoObjeto encontrado = dadoObjetoDAO.findById(dadoObjeto.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		DadoObjeto dadoObjeto = new DadoObjeto();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoObjetoPk pk = new DadoObjetoPk();
		pk.setDadoId(dado.getId());
		pk.setObjetoId(1);
		dadoObjeto.setCantidad(1);
		dadoObjeto.setId(pk);
		dadoObjetoDAO.save(dadoObjeto);
		dadoObjeto.setCantidad(2);
		dadoObjetoDAO.update(dadoObjeto);
		DadoObjeto encontrado = dadoObjetoDAO.findById(dadoObjeto.getId());
		assertTrue(2 == encontrado.getCantidad());
	}

	@Test
	public void delete() {
		DadoObjeto dadoObjeto = new DadoObjeto();
		Dado dado = new Dado();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoObjetoPk pk = new DadoObjetoPk();
		pk.setDadoId(dado.getId());
		pk.setObjetoId(1);
		dadoObjeto.setCantidad(1);
		dadoObjeto.setId(pk);
		dadoObjetoDAO.save(dadoObjeto);
		dadoObjetoDAO.delete(dadoObjeto);
		DadoObjeto encontrado = dadoObjetoDAO.findById(dadoObjeto.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Dado dado = new Dado();
		DadoObjeto dadoObjeto = new DadoObjeto();
		dado.setTipo("test");
		dado.setColor("test");
		dadoDAO.save(dado);
		DadoObjetoPk pk = new DadoObjetoPk();
		pk.setDadoId(dado.getId());
		pk.setObjetoId(1);
		dadoObjeto.setCantidad(1);
		dadoObjeto.setId(pk);
		dadoObjetoDAO.save(dadoObjeto);
		List<DadoObjeto> list = dadoObjetoDAO.list();
		assertTrue(list.size() > 0);
	}
}
