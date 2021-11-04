package com.rasmoo.rasfood.dao;

import com.rasmoo.rasfood.core.impl.CrudImplDAO;
import com.rasmoo.rasfood.entity.Dish;

import javax.persistence.EntityManager;

public class DishDAO extends CrudImplDAO<Dish>{
    private EntityManager manager;

    public DishDAO(EntityManager manager){
        super(manager);

        this.manager = manager;
    }


}