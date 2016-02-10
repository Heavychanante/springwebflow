package com.springwebflow.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class HibernateDAO<T,E> implements Dao<T, E> {

	protected Class<T> entityClass;
	protected Class<E> pkClass;

	protected SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
	public HibernateDAO(){
    	// En el constructor se guardan las clases parametrizadas
    	ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();  
        Type[] actualTypeArguments = superclass.getActualTypeArguments();  
        this.entityClass = (Class<T>) actualTypeArguments[0];
        this.pkClass = (Class<E>) actualTypeArguments[1];
    }

    @Transactional
	public void save(T entity) {
    	// Recupero la sesión de Hibernate actual
    	Session session = sessionFactory.getCurrentSession();
    	session.save(entity);
	}

	@Transactional
	public void update(T entity) {
		// Recupero la sesión de Hibernate actual
    	Session session = sessionFactory.getCurrentSession();
    	session.update(entity);
	}

	@Transactional
	public void delete(T entity) {
		// Recupero la sesión de Hibernate actual
    	Session session = sessionFactory.getCurrentSession();
    	session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T findById(E id) {
		// Recupero la sesión de Hibernate actual
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(entityClass);
    	criteria.add(Restrictions.idEq(id));
    	return (T) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> list() {
		// Recupero la sesión de Hibernate actual
    	Session session = sessionFactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(entityClass);
    	return (List<T>) criteria.list();
	}

}
