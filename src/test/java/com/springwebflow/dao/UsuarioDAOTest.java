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

import com.springwebflow.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class UsuarioDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Test
	public void save() {
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		assertNotNull(usuario.getId());
	}

	@Test
	public void findById() {
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		Usuario encontrado = usuarioDAO.findById(usuario.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		usuario.setAlias("test1");
		usuarioDAO.update(usuario);
		Usuario encontrado = usuarioDAO.findById(usuario.getId());
		assertTrue("test1".equals(encontrado.getAlias()));
	}

	@Test
	public void delete() {
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		usuarioDAO.delete(usuario);
		Usuario encontrado = usuarioDAO.findById(usuario.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		List<Usuario> list = usuarioDAO.list();
		assertTrue(list.size() > 0);
	}
}
