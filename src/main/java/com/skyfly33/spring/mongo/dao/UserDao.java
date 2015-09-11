package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.whoo.User;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 11..
 */
public interface UserDao {

    List<User> getAll();

    User findOneById(Long id);

    boolean save(User user);
}
