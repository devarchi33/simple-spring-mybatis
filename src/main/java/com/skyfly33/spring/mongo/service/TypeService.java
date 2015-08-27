package com.skyfly33.spring.mongo.service;

import com.skyfly33.spring.mongo.model.sample.Type;

import java.util.List;

/**
 * Created by donghoon on 15. 8. 27..
 */
public interface TypeService {
    void createNewType(Type type);

    void updateType(Type type);

    void removeTypeById(String id);

    List<Type> getAllDefinedTypes();

    Type getTypeById(String id);
}
