package org.mju.dao;

import java.util.List;

/**
 * Interfaz DAO. Define los métodos de acceso a datos básicos
 * @author Hugo
 *
 */
public interface Dao<T,E> {

    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findById(E id);
    public List<T> list();

}
