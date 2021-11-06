package com.rasmoo.rasfood.core;

import java.util.List;

public interface Readable<T> {
    T findById(final Long id);
    List<T> list(String queryStr);
}