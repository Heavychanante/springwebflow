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

import com.springwebflow.model.Partida;
import com.springwebflow.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class PartidaDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private PartidaDAO partidaDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Test
	public void save() {
		Partida partida = new Partida();
		partida.setNombre("test");
		partida.setActiva(Boolean.TRUE);
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		partida.setUsuario(usuario);
		partidaDAO.save(partida);
		assertNotNull(partida.getId());
	}

	@Test
	public void findById() {
		Partida partida = new Partida();
		partida.setNombre("test");
		partida.setActiva(Boolean.TRUE);
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		partida.setUsuario(usuario);
		partidaDAO.save(partida);
		Partida encontrado = partidaDAO.findById(partida.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Partida partida = new Partida();
		partida.setNombre("test");
		partida.setActiva(Boolean.TRUE);
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		partida.setUsuario(usuario);
		partidaDAO.save(partida);
		partida.setNombre("test1");
		partidaDAO.update(partida);
		Partida encontrado = partidaDAO.findById(partida.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Partida partida = new Partida();
		partida.setNombre("test");
		partida.setActiva(Boolean.TRUE);
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		partida.setUsuario(usuario);
		partidaDAO.save(partida);
		partidaDAO.delete(partida);
		Partida encontrado = partidaDAO.findById(partida.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Partida partida = new Partida();
		partida.setNombre("test");
		partida.setActiva(Boolean.TRUE);
		Usuario usuario = new Usuario();
		usuario.setAlias("test");
		usuario.setNombre("test");
		usuario.setPassword("test");
		usuarioDAO.save(usuario);
		partida.setUsuario(usuario);
		partidaDAO.save(partida);
		List<Partida> list = partidaDAO.list();
		assertTrue(list.size() > 0);
	}
}
