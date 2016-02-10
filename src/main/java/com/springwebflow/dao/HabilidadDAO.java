package com.springwebflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springwebflow.model.Clase;
import com.springwebflow.model.Habilidad;
import com.springwebflow.model.JugadorHabilidad;

@Repository
public class HabilidadDAO extends HibernateDAO<Habilidad, Integer> {

	@SuppressWarnings("unchecked")
	public List<Habilidad> getHabilidadesAsignables(Integer jugadorId, Clase clase, Integer indice, Integer cantidad, List<JugadorHabilidad> habilidadesJugador) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Habilidad.class);
		criteria.add(Restrictions.eq("clase", clase));
		for (JugadorHabilidad jugadorHabilidad : habilidadesJugador) {
			Integer id = jugadorHabilidad.getId().getHabilidadId();
			criteria.add(Restrictions.ne("id", id));
		}
		criteria.setFirstResult(indice);
		if (cantidad > 0) {
			criteria.setMaxResults(cantidad);
		}
		criteria.addOrder(Order.asc("nombre"));
		return criteria.list();
	}

}
