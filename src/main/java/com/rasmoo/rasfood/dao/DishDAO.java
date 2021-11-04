package com.rasmoo.rasfood.dao;

import com.rasmoo.rasfood.core.AbstractPersistableImplDAO;
import com.rasmoo.rasfood.core.AbstractReadableImplDAO;
import com.rasmoo.rasfood.core.CrudImplDAO;
import com.rasmoo.rasfood.core.Readable;
import com.rasmoo.rasfood.entity.Dish;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DishDAO extends CrudImplDAO<Dish>{
    private EntityManager manager;

    public DishDAO(EntityManager manager){
        super(manager);

        this.manager = manager;
    }


}