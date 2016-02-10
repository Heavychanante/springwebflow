package com.springwebflow.dao;

import static org.junit.Assert.assertNotNull;

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
}
