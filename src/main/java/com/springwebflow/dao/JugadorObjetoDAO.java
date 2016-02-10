package com.springwebflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springwebflow.model.JugadorObjeto;
import com.springwebflow.model.pk.JugadorObjetoPk;

@Repository
public class JugadorObjetoDAO extends HibernateDAO<JugadorObjeto, JugadorObjetoPk> {

	/**
	 * Método que obtiene todas los objetos de un jugador
	 * @param jugadorId Identificador del jugador
	 * @return Listado de objetos
	 */
	@SuppressWarnings("unchecked")
	public List<JugadorObjeto> getObjetosByJugador(Integer jugadorId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(JugadorObjeto.class);
		criteria.add(Restrictions.eq("id.jugadorId", jugadorId));
		return criteria.list();
	}
	
}
