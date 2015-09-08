package com.skyfly33.spring.mongo.dao;

import com.skyfly33.spring.mongo.model.whoo.Receiver;

import java.util.List;

/**
 * Created by donghoon on 15. 9. 8..
 */
public interface ReceiverDao {

    List<Receiver> getAll();

    Receiver findById(Long id);

    boolean save(Receiver receiver);
}
