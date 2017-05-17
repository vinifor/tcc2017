/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Vinicius
 */
public abstract class AbstractDao<T> {

    private Class<T> entityClass;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void save(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public Object recuperar(Class classe, Object chave) {
        return getEntityManager().find(classe, chave);
    }

    public List<T> findAll() {
        Query q = getEntityManager().createQuery("select e from " + entityClass.getSimpleName() + " e ");
        return q.getResultList();
    }

    public List<T> filter(String[] where) {
        StringBuilder sb = new StringBuilder();
        
        if (where != null) {
            sb.append(" where ");
            for (int x = 0; x < where.length; x++) {
                sb.append(where[x]);
                if (x != where.length - 1) {
                    sb.append(" AND ");
                }
            }
        }
        
        String sql = "select e from " + entityClass.getSimpleName() + " e " + sb.toString();
        Query q = getEntityManager().createQuery(sql);
        return q.getResultList();
    }

    public List<T> findRange(int[] range) {
        Query q = getEntityManager().createQuery("select e from " + entityClass.getSimpleName() + " e ");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

}
