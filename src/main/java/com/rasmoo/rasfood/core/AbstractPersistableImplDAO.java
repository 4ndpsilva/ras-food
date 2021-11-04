package com.rasmoo.rasfood.core;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public abstract class AbstractPersistableImplDAO<T> implements Persistable<T>{
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
}