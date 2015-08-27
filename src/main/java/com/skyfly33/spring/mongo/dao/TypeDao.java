package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.Type;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface TypeDao {
    public List<Type> getAll();

    public Type findById(String id);

    public Type save(Type type);
}