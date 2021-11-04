package com.rasmoo.rasfood.core;

public interface Persistable<T> {
    void delete(final Long id);
    void update(final Long id, T entity);
    T save(final T entity);
}