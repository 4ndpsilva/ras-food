package com.rasmoo.rasfood.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;
    private static EntityManager manager;

    static {
         emf = Persistence.createEntityManagerFactory("rasfood-pu");
    }

    public static EntityManager getEntityManager(){
        if(manager == null || !manager.isOpen()){
            manager = emf.createEntityManager();
        }

        return manager;
    }

    public static void close(){
        if(manager != null && manager.isOpen()){
            manager.close();
        }

        if(emf.isOpen()){
            emf.close();
        }
    }
}