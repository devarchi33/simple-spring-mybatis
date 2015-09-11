package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.whoo.User;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 8..
 */
public interface ReceiverDao {

    List<User.Server.Receiver> getAll();

    User.Server.Receiver findOneById(Long id);

    boolean save(User.Server.Receiver receiver);
}
