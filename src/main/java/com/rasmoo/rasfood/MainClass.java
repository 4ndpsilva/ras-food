package com.rasmoo.rasfood;

import com.rasmoo.rasfood.dao.GenericDAO;
import com.rasmoo.rasfood.dao.DishDAO;
import com.rasmoo.rasfood.entity.Dish;
import com.rasmoo.rasfood.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainClass {

    public static void main(String[] args) {
        EntityManager manager = JPAUtil.getEntityManager();
        GenericDAO<Dish> dao = new DishDAO(manager);

        Dish d1 = new Dish();
        d1.setName("Bife e Batata Frita");
        d1.setDescription("Ótimo prato de carne com batata, arroz e feijão");
        d1.setValue(BigDecimal.valueOf(16.50));
        d1.setAvailable(true);
        d1.setRegisterDate(LocalDateTime.now());

        dao.save(d1);

        dao.list("select d from Dish d").forEach(System.out::println);
    }
}