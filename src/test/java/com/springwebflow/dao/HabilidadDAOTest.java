package com.springwebflow.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springwebflow.model.Habilidad;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@TransactionConfiguration
@Transactional
public class HabilidadDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private HabilidadDAO habilidadDAO;

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void save() {
		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("test");
		habilidad.setDescripcion("test");
		habilidad.setPenalizacion(0);
		habilidad.setCosteExperiencia(0);
		habilidadDAO.save(habilidad);
		assertNotNull(habilidad.getId());
	}

	@Test
	public void findById() {
		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("test");
		habilidad.setDescripcion("test");
		habilidad.setPenalizacion(0);
		habilidad.setCosteExperiencia(0);
		habilidadDAO.save(habilidad);
		Habilidad encontrado = habilidadDAO.findById(habilidad.getId());
		assertNotNull(encontrado);
	}

	@Test
	public void update() {
		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("test");
		habilidad.setDescripcion("test");
		habilidad.setPenalizacion(0);
		habilidad.setCosteExperiencia(0);
		habilidadDAO.save(habilidad);
		habilidad.setNombre("test1");
		habilidadDAO.update(habilidad);
		Habilidad encontrado = habilidadDAO.findById(habilidad.getId());
		assertTrue("test1".equals(encontrado.getNombre()));
	}

	@Test
	public void delete() {
		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("test");
		habilidad.setDescripcion("test");
		habilidad.setPenalizacion(0);
		habilidad.setCosteExperiencia(0);
		habilidadDAO.save(habilidad);
		habilidadDAO.delete(habilidad);
		Habilidad encontrado = habilidadDAO.findById(habilidad.getId());
		assertNull(encontrado);
	}

	@Test
	public void list() {
		Habilidad habilidad = new Habilidad();
		habilidad.setNombre("test");
		habilidad.setDescripcion("test");
		habilidad.setPenalizacion(0);
		habilidad.setCosteExperiencia(0);
		habilidadDAO.save(habilidad);
		List<Habilidad> list = habilidadDAO.list();
		assertTrue(list.size() > 0);
	}

//	@Test
//	public void getHabilidadesAsignables() {
//		habilidadDAO.getHabilidadesAsignables(clase, indice, cantidad, habilidadesJugador)
//	}
}
