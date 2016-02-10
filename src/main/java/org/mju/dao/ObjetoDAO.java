package org.mju.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mju.model.JugadorObjeto;
import org.mju.model.Objeto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ObjetoDAO extends HibernateDAO<Objeto, Integer> {

	/**
	 * Método que devuelve un listado de objetos filtrados por el número de manos que necesitan
	 * @param manos Número de manos que necesitan los objetos (1 o 2)
	 * @return Listado de objetos
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Objeto> getObjetosByManos(Integer manos) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Objeto.class);
		criteria.add(Restrictions.eq("manos", manos));
		return (List<Objeto>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Objeto> getObjetosAsignables(Integer jugadorId, Integer indice, Integer cantidad, List<JugadorObjeto> objetosJugador) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Objeto.class);
		for (JugadorObjeto jugadorObjeto : objetosJugador) {
			Integer id = jugadorObjeto.getId().getObjetoId();
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
