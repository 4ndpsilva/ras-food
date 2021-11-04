package com.rasmoo.rasfood.core.impl;

import com.rasmoo.rasfood.core.Persistable;
import com.rasmoo.rasfood.core.Readable;
import com.rasmoo.rasfood.core.TransactionManager;
import com.rasmoo.rasfood.entity.Dish;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
public class CrudImplDAO<T> implements Persistable<T>, Readable<T> {
    private final EntityManager manager;

    @Override
    public T save(final T entity) {
        try{
            TransactionManager.beginTransaction(manager);
            T savedEntity = manager.merge(entity);
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
        manager.remove(id);
        TransactionManager.commit(manager);
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public List<T> list(String queryStr, Class<T> clazz) {
        TypedQuery<T> query = manager.createQuery(queryStr, clazz);
        return query.getResultList();
    }
}