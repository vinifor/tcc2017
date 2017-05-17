/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.dao;

import java.math.BigInteger;
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

    public void removeAll(String tabela, String coluna, Long id) {
        Query q = getEntityManager().createNativeQuery("delete from " + tabela + " where " + coluna + " = " + id);
        q.executeUpdate();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public Object recuperar(Class classe, Object chave) {
        return getEntityManager().find(classe, chave);
    }

    public List<T> findAll() {
        Query q = getEntityManager().createQuery("from " + entityClass.getSimpleName());
        return q.getResultList();
    }

    public List<T> findRange(int[] range) {
        Query q = getEntityManager().createQuery("from " + entityClass.getSimpleName());
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        Query q = getEntityManager().createQuery("from " + entityClass.getSimpleName());
        return q.getResultList().size();///ERRADO!!!
    }

    public List<T> filter(String[] where, String[] order, String[] group) {
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

        if (group != null) {
            sb.append(" group by ");
            for (int x = 0; x < group.length; x++) {
                sb.append(group[x]);
                if (x != group.length - 1) {
                    sb.append(" , ");
                }
            }
        }
        if (order != null) {
            sb.append(" order by ");
            for (int x = 0; x < order.length; x++) {
                sb.append(order[x]);
                if (x != order.length - 1) {
                    sb.append(" , ");
                }
            }
        }

        String sql = " from " + entityClass.getSimpleName() + " " + sb.toString();
        Query q = getEntityManager().createQuery(sql);
        return q.getResultList();
    }

    public Object filter(String sql) {
        Query q = getEntityManager().createNativeQuery(sql);
        return q.getSingleResult();
    }

}
