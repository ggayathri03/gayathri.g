
package com.example.hibernatecrud.dao;

import com.example.hibernatecrud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.function.Consumer;

public class BaseDao<T> {
    private final Class<T> entityClass;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T save(T entity) {
        return executeWithinTransaction(session -> session.save(entity), entity);
    }

    public T update(T entity) {
        return executeWithinTransaction(session -> session.update(entity), entity);
    }

    public void deleteById(Long id) {
        executeWithinTransaction(session -> {
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.delete(entity);
            }
        }, null);
    }

    public T findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
        }
    }

    private T executeWithinTransaction(Consumer<Session> action, T entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            action.accept(session);
            tx.commit();
            return entity;
        } catch (RuntimeException e) {
            if (tx != null && tx.getStatus().canRollback()) tx.rollback();
            throw e;
        }
    }
}
