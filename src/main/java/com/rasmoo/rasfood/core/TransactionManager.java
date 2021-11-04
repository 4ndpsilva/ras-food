package com.rasmoo.rasfood.core;

import javax.persistence.EntityManager;

public class TransactionManager {
    public static void beginTransaction(final EntityManager manager){
        manager.getTransaction().begin();
    }

    public static void commit(final EntityManager manager){
        manager.getTransaction().commit();
    }

    public static void rollback(final EntityManager manager){
        manager.getTransaction().rollback();
    }
}