package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.whoo.User;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 11..
 */
public interface ServerDao {
    List<User.Server> getAll();

    User.Server findOneById(Long id);

    boolean save(User.Server receiver);
}
