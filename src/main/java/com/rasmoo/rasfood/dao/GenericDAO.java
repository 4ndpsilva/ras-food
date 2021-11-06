package com.rasmoo.rasfood.dao;

import com.rasmoo.rasfood.core.Persistable;
import com.rasmoo.rasfood.core.Readable;
import com.rasmoo.rasfood.core.TransactionManager;
import com.rasmoo.rasfood.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
public abstract class GenericDAO<T> implements Persistable<T>, Readable<T> {
    private final Class<T> entityClass;
    private final EntityManager manager;

    @Override
    public T save(final T entity) {
        try{
            TransactionManager.beginTransaction(manager);
            final T savedEntity = manager.merge(entity);
            TransactionManager.commit(manager);
            return savedEntity;
        }
        catch (Exception ex){
            TransactionManager.rollback(manager);
            return null;
        }
    }

    @Override
    public void update(final Long id, final T entity) {
        final T findEntity = (T) manager.find(entity.getClass(), id);
    }

    @Override
    public void delete(final Long id) {
        TransactionManager.beginTransaction(manager);
        final T entity = findById(id);
        manager.remove(entity);
        TransactionManager.commit(manager);
    }

    @Override
    public T findById(Long id) {
        return manager.find(null, id);
    }

    @Override
    public List<T> list(String queryStr) {
        final TypedQuery<T> query = manager.createQuery(queryStr, entityClass);
        return query.getResultList();
    }
}