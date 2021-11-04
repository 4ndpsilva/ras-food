package com.rasmoo.rasfood;

import com.rasmoo.rasfood.core.AbstractPersistableImplDAO;
import com.rasmoo.rasfood.core.CrudImplDAO;
import com.rasmoo.rasfood.dao.DishDAO;
import com.rasmoo.rasfood.entity.Dish;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainClass {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rasfood-pu");

    public static void main(String[] args) {
        EntityManager manager = emf.createEntityManager();
        CrudImplDAO<Dish> dao = new DishDAO(manager);

        Dish entity = new Dish();
        entity.setName("Bife e Batata Frita");
        entity.setDescription("Ótimo prato de carne com batata");
        entity.setValue(BigDecimal.valueOf(16.50));
        entity.setAvailable(true);
        entity.setRegisterDate(LocalDateTime.now());

        dao.save(entity);

        dao.list("select d from Dish d", Dish.class)
                .forEach(System.out::println);
    }
}