package com.springwebflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springwebflow.model.JugadorHabilidad;
import com.springwebflow.model.pk.JugadorHabilidadPk;

@Repository
public class JugadorHabilidadDAO extends HibernateDAO<JugadorHabilidad, JugadorHabilidadPk> {

	/**
	 * Método que obtiene todas las habilidades de un jugador
	 * @param jugadorId Identificador del jugador
	 * @return Listado de habilidades
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorHabilidad> getHabilidadesByJugador(Integer jugadorId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(JugadorHabilidad.class);
		criteria.add(Restrictions.eq("id.jugadorId", jugadorId));
		return criteria.list();
	}

}
