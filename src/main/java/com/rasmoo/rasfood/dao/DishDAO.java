package com.rasmoo.rasfood.dao;

import com.rasmoo.rasfood.entity.Dish;

import javax.persistence.EntityManager;

public class DishDAO extends GenericDAO<Dish> {
    public DishDAO(EntityManager manager){
        super(Dish.class, manager);
    }
}