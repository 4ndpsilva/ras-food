package com.rasmoo.rasfood.core;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractReadableImplDAO<T> implements Readable<T> {
    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public List<T> list(String queryStr, Class<T> clazz) {
        return null;
    }
}