package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.sample.Type;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface TypeDao {
    List<Type> getAll();

    Type findById(String id);

    Type save(Type type);
}
